package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import modelDominio.*;
import model.*;

public class TrataClienteController extends Thread {
    private int idUnico;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    private ClienteDAO clienteDAO;
    private VeiculoDAO veiculoDAO;
    private FuncionarioDAO funcionarioDAO;
    private UsuarioDAO usuarioDAO;
    private ServicoDAO servicoDAO;
    private AgendamentoDAO agendamentoDAO;

    public TrataClienteController(Socket socket, int idUnico) {
        this.socket = socket;
        this.idUnico = idUnico;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            clienteDAO = new ClienteDAO();
            veiculoDAO = new VeiculoDAO();
            funcionarioDAO = new FuncionarioDAO();
            usuarioDAO = new UsuarioDAO();
            servicoDAO = new ServicoDAO();
            agendamentoDAO = new AgendamentoDAO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente Id: "+idUnico);
            String operacao;
            while ((operacao = (String) in.readObject()) != null) {
                try {
                    switch (operacao) {
                        
                        //--------LOGIN---------
                        case "login":
                            String[] credenciais = (String[]) in.readObject(); // [login, senhaHash]
                            String email = credenciais[0];
                            String senhaHash = credenciais[1];

                            // Primeiro tenta autenticar como usuário
                            Usuario usuario = usuarioDAO.autenticar(email, senhaHash);
                            if (usuario != null) {
                                out.writeObject(usuario);
                                break;
                            }

                            // Se chegou aqui, credenciais inválidas
                            out.writeObject(null);
                            break;

                        // -------- CLIENTE --------
                        case "inserirCliente":
                            Cliente novoCliente = (Cliente) in.readObject();
                            clienteDAO.insert(novoCliente);
                            out.writeObject("SUCCESS");
                            break;
                        case "atualizarCliente":
                            Cliente clienteUpd = (Cliente) in.readObject();
                            clienteDAO.update(clienteUpd);
                            out.writeObject("SUCCESS");
                            break;
                        case "excluirCliente":
                            Integer clienteId = (Integer) in.readObject();
                            clienteDAO.delete(clienteId);
                            out.writeObject("SUCCESS");
                            break;
                        case "buscarClientePorId":
                            Integer idCliente = (Integer) in.readObject();
                            out.writeObject(clienteDAO.findById(idCliente));
                            break;
                        case "listarClientes":
                            out.writeObject(clienteDAO.findAll());
                            break;

                        // -------- VEICULO --------
                        case "inserirVeiculo":
                            Veiculo novoVeiculo = (Veiculo) in.readObject();
                            veiculoDAO.insert(novoVeiculo);
                            out.writeObject("SUCCESS");
                            break;
                        case "atualizarVeiculo":
                            Veiculo veiculoUpd = (Veiculo) in.readObject();
                            veiculoDAO.update(veiculoUpd);
                            out.writeObject("SUCCESS");
                            break;
                        case "excluirVeiculo":
                            Integer veiculoId = (Integer) in.readObject();
                            veiculoDAO.delete(veiculoId);
                            out.writeObject("SUCCESS");
                            break;
                        case "buscarVeiculoPorId":
                            Integer idVeiculo = (Integer) in.readObject();
                            out.writeObject(veiculoDAO.findById(idVeiculo));
                            break;
                        case "listarVeiculos":
                            out.writeObject(veiculoDAO.findAll());
                            break;

                        // -------- FUNCIONARIO --------
                        case "inserirFuncionario":
                            Funcionario novoFunc = (Funcionario) in.readObject();
                            funcionarioDAO.insert(novoFunc);
                            out.writeObject("SUCCESS");
                            break;
                        case "atualizarFuncionario":
                            Funcionario funcUpd = (Funcionario) in.readObject();
                            funcionarioDAO.update(funcUpd);
                            out.writeObject("SUCCESS");
                            break;
                        case "excluirFuncionario":
                            Integer funcId = (Integer) in.readObject();
                            funcionarioDAO.delete(funcId);
                            out.writeObject("SUCCESS");
                            break;
                        case "buscarFuncionarioPorId":
                            Integer idFuncionario = (Integer) in.readObject();
                            out.writeObject(funcionarioDAO.findById(idFuncionario));
                            break;
                        case "listarFuncionarios":
                            out.writeObject(funcionarioDAO.findAll());
                            break;

                        // -------- USUARIO --------
                        case "inserirUsuario":
                            Usuario novoUser = (Usuario) in.readObject();
                            usuarioDAO.insert(novoUser);
                            out.writeObject("SUCCESS");
                            break;
                        case "atualizarUsuario":
                            Usuario userUpd = (Usuario) in.readObject();
                            usuarioDAO.update(userUpd);
                            out.writeObject("SUCCESS");
                            break;
                        case "excluirUsuario":
                            Integer userId = (Integer) in.readObject();
                            usuarioDAO.delete(userId);
                            out.writeObject("SUCCESS");
                            break;
                        case "buscarUsuarioPorId":
                            Integer idUsuario = (Integer) in.readObject();
                            out.writeObject(usuarioDAO.findById(idUsuario));
                            break;
                        case "listarUsuarios":
                            out.writeObject(usuarioDAO.findAll());
                            break;
                            
                        // -------- SERVICO --------
                        case "inserirServico":
                            Servico novoServ = (Servico) in.readObject();
                            servicoDAO.insert(novoServ);
                            out.writeObject("SUCCESS");
                            break;
                        case "atualizarServico":
                            Servico servUpd = (Servico) in.readObject();
                            servicoDAO.update(servUpd);
                            out.writeObject("SUCCESS");
                            break;
                        case "excluirServico":
                            Integer servId = (Integer) in.readObject();
                            servicoDAO.delete(servId);
                            out.writeObject("SUCCESS");
                            break;
                        case "buscarServicoPorId":
                            Integer idServico = (Integer) in.readObject();
                            out.writeObject(servicoDAO.findById(idServico));
                            break;
                        case "listarServicos":
                            out.writeObject(servicoDAO.findAll());
                            break;

                        // -------- AGENDAMENTO --------
                        case "inserirAgendamento":
                            Agendamento novoAg = (Agendamento) in.readObject();
                            agendamentoDAO.insert(novoAg);
                            out.writeObject("SUCCESS");
                            break;
                        case "atualizarAgendamento":
                            Agendamento agUpd = (Agendamento) in.readObject();
                            agendamentoDAO.update(agUpd);
                            out.writeObject("SUCCESS");
                            break;
                        case "excluirAgendamento":
                            Integer agId = (Integer) in.readObject();
                            agendamentoDAO.delete(agId);
                            out.writeObject("SUCCESS");
                            break;
                        case "buscarAgendamentoPorId":
                            Integer idAgendamento = (Integer) in.readObject();
                            out.writeObject(agendamentoDAO.findById(idAgendamento));
                            break;
                        case "listarAgendamentos":
                            out.writeObject(agendamentoDAO.findAll());
                            break;

                        default:
                            System.out.println("Operação desconhecida: " + operacao);
                            out.writeObject("OPERATION_NOT_FOUND");
                            break;
                    }
                } catch (SQLException e) {
                    System.err.println("Erro SQL na operação " + operacao + ": " + e.getMessage());
                    out.writeObject("ERROR: " + e.getMessage());
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Erro na operação " + operacao + ": " + e.getMessage());
                    out.writeObject("ERROR: " + e.getMessage());
                }

                out.flush();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cliente desconectado: " + socket.getInetAddress());
        } finally {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}