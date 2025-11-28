package com.example.projetolavatech.controller;

import android.util.Log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import modelDominio.Agendamento;
import modelDominio.Cliente;
import modelDominio.Funcionario;
import modelDominio.Servico;
import modelDominio.Usuario;
import modelDominio.Veiculo;

/**
 * Controller de conexão reutilizando o protocolo do cliente desktop.
 * Usa ObjectInputStream/ObjectOutputStream para conversar com o servidor Java.
 */
public class ConexaoController {
    private static ConexaoController instance;

    private Socket cliente;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    // Executor para operações em background
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    // Estado da conexão
    private volatile EstadoConexao estado = EstadoConexao.DESCONECTADO;
    
    // IP do servidor armazenado após primeira conexão bem-sucedida
    private String serverIPArmazenado = null;

    private ConexaoController() {}

    public static synchronized ConexaoController getInstance() {
        if (instance == null) {
            instance = new ConexaoController();
        }
        return instance;
    }

    // Estados possíveis da conexão
    public enum EstadoConexao {
        DESCONECTADO,
        CONECTANDO,
        CONECTADO,
        ERRO
    }

    /**
     * Garante que exista uma conexão ativa com o servidor antes de executar onSuccess.
     * Usa o IP armazenado de uma conexão anterior, ou retorna erro se não houver IP armazenado.
     * @param onSuccess Callback executado quando a conexão for estabelecida
     * @param onError Callback executado em caso de erro na conexão
     */
    public void executar(Runnable onSuccess, Runnable onError) {
        if (serverIPArmazenado == null || serverIPArmazenado.isEmpty()) {
            Log.e("ConexaoController", "Tentativa de conexão sem IP do servidor. Use executar(serverIP, ...) primeiro.");
            if (onError != null) {
                onError.run();
            }
            return;
        }
        executar(serverIPArmazenado, onSuccess, onError);
    }

    /**
     * Garante que exista uma conexão ativa com o servidor antes de executar onSuccess.
     * @param serverIP IP do servidor (ex: "192.168.1.100" ou "10.0.2.2" para emulador)
     * @param onSuccess Callback executado quando a conexão for estabelecida
     * @param onError Callback executado em caso de erro na conexão
     */
    public void executar(String serverIP, Runnable onSuccess, Runnable onError) {
        // Se já estiver conectado, executa direto na thread do executor para garantir sincronização
        if (estado == EstadoConexao.CONECTADO) {
            if (onSuccess != null) {
                executor.execute(onSuccess);
            }
            return;
        }
        // Evita múltiplas tentativas concorrentes
        if (estado == EstadoConexao.CONECTANDO) {
            Log.w("ConexaoController", "Já está conectando, ignorando nova tentativa...");
            return;
        }

        estado = EstadoConexao.CONECTANDO;

        executor.execute(() -> {
            try {
                // IMPORTANTE: ajuste o host para o IP da máquina que roda o servidor
                // Em emulador Android Studio use 10.0.2.2, em dispositivo físico use o IP da rede (ex: 192.168.x.x)
                Log.d("ConexaoController", "Tentando conectar ao servidor " + serverIP + ":12345...");
                
                // Fechar conexão anterior se existir
                desconectarConexaoAnterior();
                
                cliente = new Socket(serverIP, 12345);
                Log.d("ConexaoController", "Socket criado com sucesso!");
                
                // IMPORTANTE: O servidor cria ObjectOutputStream primeiro (linha 29 do TrataClienteController)
                // e envia um header. O cliente DEVE criar ObjectInputStream primeiro para ler esse header,
                // caso contrário haverá deadlock. Depois criamos o OutputStream do cliente.
                in = new ObjectInputStream(cliente.getInputStream());
                Log.d("ConexaoController", "ObjectInputStream criado (lendo header do servidor)...");
                
                out = new ObjectOutputStream(cliente.getOutputStream());
                out.flush(); // Força o envio do header do cliente
                Log.d("ConexaoController", "ObjectOutputStream criado! Conexão estabelecida.");

                estado = EstadoConexao.CONECTADO;
                // Armazenar o IP para uso em conexões futuras
                serverIPArmazenado = serverIP;
                Log.d("ConexaoController", "Estado alterado para CONECTADO. IP armazenado: " + serverIP);
                Log.d("ConexaoController", "Executando callback onSuccess...");
                
                // Executar onSuccess na thread do executor para garantir sincronização
                if (onSuccess != null) {
                    onSuccess.run();
                }
            } catch (IOException e) {
                Log.e("ConexaoController", "Erro ao conectar: " + e.getMessage(), e);
                e.printStackTrace();
                estado = EstadoConexao.ERRO;
                if (onError != null) onError.run();
            }
        });
    }

    private void desconectarConexaoAnterior() {
        try {
            if (in != null) {
                in.close();
                in = null;
            }
            if (out != null) {
                out.close();
                out = null;
            }
            if (cliente != null && !cliente.isClosed()) {
                cliente.close();
                cliente = null;
            }
        } catch (IOException e) {
            Log.w("ConexaoController", "Erro ao fechar conexão anterior: " + e.getMessage());
        }
    }

    public void desconectar() {
        estado = EstadoConexao.DESCONECTADO;
        // Não limpar o serverIPArmazenado para permitir reconexão automática
        executor.execute(() -> {
            desconectarConexaoAnterior();
        });
    }

    // ===================== LOGIN =====================

    /**
     * Faz login usando o mesmo protocolo do cliente desktop:
     * envia operação \"login\" + [email, senhaHash] e recebe um Usuario ou null.
     */
    public Future<Usuario> login(String email, String senhaHash) {
        Callable<Usuario> tarefa = () -> {
            if (estado != EstadoConexao.CONECTADO) {
                Log.e("ConexaoController", "Tentativa de login sem conexão estabelecida!");
                throw new IllegalStateException("Cliente não está conectado");
            }
            try {
                // Verificar novamente se está conectado antes de enviar
                if (estado != EstadoConexao.CONECTADO || out == null || in == null) {
                    Log.e("ConexaoController", "Streams não estão prontos! Estado: " + estado + ", out: " + (out != null) + ", in: " + (in != null));
                    throw new IllegalStateException("Streams não estão prontos");
                }
                
                Log.d("ConexaoController", "Enviando comando 'login' para o servidor...");
                synchronized (out) {
                    out.writeObject("login");
                    Log.d("ConexaoController", "Comando 'login' enviado!");
                    
                    String[] credenciais = { email, senhaHash };
                    out.writeObject(credenciais);
                    Log.d("ConexaoController", "Credenciais enviadas!");
                    
                    out.flush();
                    Log.d("ConexaoController", "Flush realizado! Aguardando resposta do servidor...");
                }

                Object resposta = null;
                synchronized (in) {
                    Log.d("ConexaoController", "Lendo resposta do servidor...");
                    resposta = in.readObject();
                    Log.d("ConexaoController", "Resposta recebida: " + (resposta != null ? "Usuario válido" : "null"));
                }
                return (Usuario) resposta;
            } catch (Exception e) {
                Log.e("ConexaoController", "Erro no login: " + e.getMessage(), e);
                e.printStackTrace();
                // Se houver erro, desconectar para permitir nova tentativa
                estado = EstadoConexao.ERRO;
                desconectarConexaoAnterior();
                return null;
            }
        };
        return executor.submit(tarefa);
    }

    // ===================== AGENDAMENTOS =====================

    public Future<ArrayList<Agendamento>> listarAgendamentos() {
        Callable<ArrayList<Agendamento>> tarefa = () -> {
            if (estado != EstadoConexao.CONECTADO) {
                Log.e("ConexaoController", "Tentativa de listar agendamentos sem conexão estabelecida!");
                throw new IllegalStateException("Cliente não está conectado");
            }
            try {
                // Verificar novamente se está conectado antes de enviar
                if (estado != EstadoConexao.CONECTADO || out == null || in == null) {
                    Log.e("ConexaoController", "Streams não estão prontos! Estado: " + estado + ", out: " + (out != null) + ", in: " + (in != null));
                    throw new IllegalStateException("Streams não estão prontos");
                }
                
                Log.d("ConexaoController", "Enviando comando 'listarAgendamentos' para o servidor...");
                synchronized (out) {
                    out.writeObject("listarAgendamentos");
                    out.flush();
                    Log.d("ConexaoController", "Comando 'listarAgendamentos' enviado! Aguardando resposta...");
                }

                Object resp = null;
                synchronized (in) {
                    Log.d("ConexaoController", "Lendo resposta do servidor...");
                    resp = in.readObject();
                    Log.d("ConexaoController", "Resposta recebida do tipo: " + (resp != null ? resp.getClass().getSimpleName() : "null"));
                }
                
                // O servidor retorna um ArrayList<Agendamento>
                @SuppressWarnings("unchecked")
                ArrayList<Agendamento> lista = (ArrayList<Agendamento>) resp;
                Log.d("ConexaoController", "Lista de agendamentos recebida: " + (lista != null ? lista.size() + " itens" : "null"));
                return lista != null ? lista : new ArrayList<>();
            } catch (Exception e) {
                Log.e("ConexaoController", "Erro ao listar agendamentos: " + e.getMessage(), e);
                e.printStackTrace();
                return new ArrayList<>();
            }
        };
        return executor.submit(tarefa);
    }

    public Future<Boolean> inserirAgendamento(Agendamento a) {
        Callable<Boolean> tarefa = () -> enviarObjeto("inserirAgendamento", a);
        return executor.submit(tarefa);
    }

    public Future<Boolean> atualizarAgendamento(Agendamento a) {
        Callable<Boolean> tarefa = () -> {
            if (estado != EstadoConexao.CONECTADO) {
                Log.e("ConexaoController", "Tentativa de atualizar agendamento sem conexão estabelecida!");
                throw new IllegalStateException("Cliente não está conectado");
            }
            try {
                if (estado != EstadoConexao.CONECTADO || out == null || in == null) {
                    Log.e("ConexaoController", "Streams não estão prontos!");
                    throw new IllegalStateException("Streams não estão prontos");
                }
                
                Log.d("ConexaoController", "Enviando comando 'atualizarAgendamento' para o servidor...");
                synchronized (out) {
                    out.writeObject("atualizarAgendamento");
                    out.writeObject(a);
                    out.flush();
                    Log.d("ConexaoController", "Agendamento enviado para atualização!");
                }
                
                Object resposta = null;
                synchronized (in) {
                    resposta = in.readObject();
                    Log.d("ConexaoController", "Resposta recebida: " + resposta);
                }
                
                boolean sucesso = resposta instanceof String && "SUCCESS".equals(resposta);
                Log.d("ConexaoController", "Atualização " + (sucesso ? "bem-sucedida" : "falhou"));
                return sucesso;
            } catch (Exception e) {
                Log.e("ConexaoController", "Erro ao atualizar agendamento: " + e.getMessage(), e);
                e.printStackTrace();
                return false;
            }
        };
        return executor.submit(tarefa);
    }

    public Future<Boolean> excluirAgendamento(int id) {
        Callable<Boolean> tarefa = () -> enviarObjeto("excluirAgendamento", id);
        return executor.submit(tarefa);
    }

    // ===================== CLIENTES =====================

    public Future<ArrayList<Cliente>> listarClientes() {
        Callable<ArrayList<Cliente>> tarefa = () -> {
            if (estado != EstadoConexao.CONECTADO) {
                throw new IllegalStateException("Cliente não está conectado");
            }
            try {
                synchronized (out) {
                    out.writeObject("listarClientes");
                    out.flush();
                }
                Object resp = null;
                synchronized (in) {
                    resp = in.readObject();
                }
                @SuppressWarnings("unchecked")
                ArrayList<Cliente> lista = (ArrayList<Cliente>) resp;
                return lista != null ? lista : new ArrayList<>();
            } catch (Exception e) {
                Log.e("ConexaoController", "Erro ao listar clientes: " + e.getMessage(), e);
                return new ArrayList<>();
            }
        };
        return executor.submit(tarefa);
    }

    public Future<Cliente> buscarClientePorId(int id) {
        Callable<Cliente> tarefa = () -> {
            if (estado != EstadoConexao.CONECTADO) {
                throw new IllegalStateException("Cliente não está conectado");
            }
            try {
                synchronized (out) {
                    out.writeObject("buscarClientePorId");
                    out.writeObject(id);
                    out.flush();
                }
                Object resp = null;
                synchronized (in) {
                    resp = in.readObject();
                }
                return (Cliente) resp;
            } catch (Exception e) {
                Log.e("ConexaoController", "Erro ao buscar cliente: " + e.getMessage(), e);
                return null;
            }
        };
        return executor.submit(tarefa);
    }

    // ===================== VEÍCULOS =====================

    public Future<ArrayList<Veiculo>> listarVeiculosPorCliente(int clienteId) {
        Callable<ArrayList<Veiculo>> tarefa = () -> {
            if (estado != EstadoConexao.CONECTADO) {
                throw new IllegalStateException("Cliente não está conectado");
            }
            try {
                synchronized (out) {
                    out.writeObject("listarVeiculosPorCliente");
                    out.writeObject(clienteId);
                    out.flush();
                }
                Object resp = null;
                synchronized (in) {
                    resp = in.readObject();
                }
                @SuppressWarnings("unchecked")
                ArrayList<Veiculo> lista = (ArrayList<Veiculo>) resp;
                return lista != null ? lista : new ArrayList<>();
            } catch (Exception e) {
                Log.e("ConexaoController", "Erro ao listar veículos: " + e.getMessage(), e);
                return new ArrayList<>();
            }
        };
        return executor.submit(tarefa);
    }

    public Future<Veiculo> buscarVeiculoPorId(int id) {
        Callable<Veiculo> tarefa = () -> {
            if (estado != EstadoConexao.CONECTADO) {
                throw new IllegalStateException("Cliente não está conectado");
            }
            try {
                synchronized (out) {
                    out.writeObject("buscarVeiculoPorId");
                    out.writeObject(id);
                    out.flush();
                }
                Object resp = null;
                synchronized (in) {
                    resp = in.readObject();
                }
                return (Veiculo) resp;
            } catch (Exception e) {
                Log.e("ConexaoController", "Erro ao buscar veículo: " + e.getMessage(), e);
                return null;
            }
        };
        return executor.submit(tarefa);
    }

    // ===================== FUNCIONÁRIOS =====================

    public Future<ArrayList<Funcionario>> listarFuncionarios() {
        Callable<ArrayList<Funcionario>> tarefa = () -> {
            if (estado != EstadoConexao.CONECTADO) {
                throw new IllegalStateException("Cliente não está conectado");
            }
            try {
                synchronized (out) {
                    out.writeObject("listarFuncionarios");
                    out.flush();
                }
                Object resp = null;
                synchronized (in) {
                    resp = in.readObject();
                }
                @SuppressWarnings("unchecked")
                ArrayList<Funcionario> lista = (ArrayList<Funcionario>) resp;
                return lista != null ? lista : new ArrayList<>();
            } catch (Exception e) {
                Log.e("ConexaoController", "Erro ao listar funcionários: " + e.getMessage(), e);
                return new ArrayList<>();
            }
        };
        return executor.submit(tarefa);
    }

    public Future<Funcionario> buscarFuncionarioPorId(int id) {
        Callable<Funcionario> tarefa = () -> {
            if (estado != EstadoConexao.CONECTADO) {
                throw new IllegalStateException("Cliente não está conectado");
            }
            try {
                synchronized (out) {
                    out.writeObject("buscarFuncionarioPorId");
                    out.writeObject(id);
                    out.flush();
                }
                Object resp = null;
                synchronized (in) {
                    resp = in.readObject();
                }
                return (Funcionario) resp;
            } catch (Exception e) {
                Log.e("ConexaoController", "Erro ao buscar funcionário: " + e.getMessage(), e);
                return null;
            }
        };
        return executor.submit(tarefa);
    }

    // ===================== SERVIÇOS =====================

    public Future<ArrayList<Servico>> listarServicos() {
        Callable<ArrayList<Servico>> tarefa = () -> {
            if (estado != EstadoConexao.CONECTADO) {
                throw new IllegalStateException("Cliente não está conectado");
            }
            try {
                synchronized (out) {
                    out.writeObject("listarServicos");
                    out.flush();
                }
                Object resp = null;
                synchronized (in) {
                    resp = in.readObject();
                }
                @SuppressWarnings("unchecked")
                ArrayList<Servico> lista = (ArrayList<Servico>) resp;
                return lista != null ? lista : new ArrayList<>();
            } catch (Exception e) {
                Log.e("ConexaoController", "Erro ao listar serviços: " + e.getMessage(), e);
                return new ArrayList<>();
            }
        };
        return executor.submit(tarefa);
    }

    public Future<Servico> buscarServicoPorId(int id) {
        Callable<Servico> tarefa = () -> {
            if (estado != EstadoConexao.CONECTADO) {
                throw new IllegalStateException("Cliente não está conectado");
            }
            try {
                synchronized (out) {
                    out.writeObject("buscarServicoPorId");
                    out.writeObject(id);
                    out.flush();
                }
                Object resp = null;
                synchronized (in) {
                    resp = in.readObject();
                }
                return (Servico) resp;
            } catch (Exception e) {
                Log.e("ConexaoController", "Erro ao buscar serviço: " + e.getMessage(), e);
                return null;
            }
        };
        return executor.submit(tarefa);
    }

    // ===================== AUXILIARES =====================

    private boolean enviarObjeto(String operacao, Object obj) {
        if (estado != EstadoConexao.CONECTADO) {
            throw new IllegalStateException("Cliente não está conectado");
        }
        try {
            out.writeObject(operacao);
            out.writeObject(obj);
            out.flush();
            Object resposta = in.readObject();
            return resposta instanceof String && "SUCCESS".equals(resposta);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

