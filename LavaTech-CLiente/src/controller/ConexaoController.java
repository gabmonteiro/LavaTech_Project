package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelDominio.Agendamento;
import modelDominio.Cliente;
import modelDominio.Funcionario;
import modelDominio.Servico;
import modelDominio.Usuario;
import modelDominio.Veiculo;

public class ConexaoController {
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Usuario userLogado;

    public ConexaoController(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public Usuario getUserLogado() {
        return userLogado;
    }

    public void setUserLogado(Usuario userLogado) {
        this.userLogado = userLogado;
    }

    // ---------- LOGIN ----------
    public Usuario login(String email, String senhaHash) {
        try {
            out.writeObject("login");
            String[] credenciais = { email, senhaHash };
            out.writeObject(credenciais);
            out.flush();

            Usuario usuario = (Usuario) in.readObject();
            if (usuario != null) {
                this.userLogado = usuario;
            }
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ---------- CLIENTE ----------
    public boolean inserirCliente(Cliente c) {
        return enviarObjeto("inserirCliente", c);
    }

    public boolean atualizarCliente(Cliente c) {
        return enviarObjeto("atualizarCliente", c);
    }

    public boolean excluirCliente(int id) {
        return enviarObjeto("excluirCliente", id);
    }

    public Cliente buscarClientePorId(int id) {
        return (Cliente) requisitarObjeto("buscarClientePorId", id);
    }

    public ArrayList<Cliente> listarClientes() {
        return (ArrayList<Cliente>) requisitarLista("listarClientes");
    }

    // ---------- VEICULO ----------
    public boolean inserirVeiculo(Veiculo v) {
        return enviarObjeto("inserirVeiculo", v);
    }

    public boolean atualizarVeiculo(Veiculo v) {
        return enviarObjeto("atualizarVeiculo", v);
    }

    public boolean excluirVeiculo(int id) {
        return enviarObjeto("excluirVeiculo", id);
    }

    public Veiculo buscarVeiculoPorId(int id) {
        return (Veiculo) requisitarObjeto("buscarVeiculoPorId", id);
    }

    public ArrayList<Veiculo> listarVeiculos() {
        return (ArrayList<Veiculo>) requisitarLista("listarVeiculos");
    }

    // ---------- FUNCIONARIO ----------
    public boolean inserirFuncionario(Funcionario f) {
        return enviarObjeto("inserirFuncionario", f);
    }

    public boolean atualizarFuncionario(Funcionario f) {
        return enviarObjeto("atualizarFuncionario", f);
    }

    public boolean excluirFuncionario(int id) {
        return enviarObjeto("excluirFuncionario", id);
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        return (Funcionario) requisitarObjeto("buscarFuncionarioPorId", id);
    }

    public ArrayList<Funcionario> listarFuncionarios() {
        return (ArrayList<Funcionario>) requisitarLista("listarFuncionarios");
    }

    // ---------- USUARIO ----------
    public boolean inserirUsuario(Usuario u) {
        return enviarObjeto("inserirUsuario", u);
    }

    public boolean atualizarUsuario(Usuario u) {
        return enviarObjeto("atualizarUsuario", u);
    }

    public boolean excluirUsuario(int id) {
        return enviarObjeto("excluirUsuario", id);
    }

    public Usuario buscarUsuarioPorId(int id) {
        return (Usuario) requisitarObjeto("buscarUsuarioPorId", id);
    }

    public ArrayList<Usuario> listarUsuarios() {
        return (ArrayList<Usuario>) requisitarLista("listarUsuarios");
    }

    // ---------- SERVICO ----------
    public boolean inserirServico(Servico s) {
        return enviarObjeto("inserirServico", s);
    }

    public boolean atualizarServico(Servico s) {
        return enviarObjeto("atualizarServico", s);
    }

    public boolean excluirServico(int id) {
        return enviarObjeto("excluirServico", id);
    }

    public Servico buscarServicoPorId(int id) {
        return (Servico) requisitarObjeto("buscarServicoPorId", id);
    }

    public ArrayList<Servico> listarServicos() {
        return (ArrayList<Servico>) requisitarLista("listarServicos");
    }

    // ---------- AGENDAMENTO ----------
    public boolean inserirAgendamento(Agendamento a) {
        return enviarObjeto("inserirAgendamento", a);
    }

    public boolean atualizarAgendamento(Agendamento a) {
        return enviarObjeto("atualizarAgendamento", a);
    }

    public boolean excluirAgendamento(int id) {
        return enviarObjeto("excluirAgendamento", id);
    }

    public Agendamento buscarAgendamentoPorId(int id) {
        return (Agendamento) requisitarObjeto("buscarAgendamentoPorId", id);
    }

    public ArrayList<Agendamento> listarAgendamentos() {
        return (ArrayList<Agendamento>) requisitarLista("listarAgendamentos");
    }

    // ==================================================
    // MÉTODOS AUXILIARES PADRONIZADOS
    // ==================================================

    private boolean enviarObjeto(String operacao, Object obj) {
        try {
            out.writeObject(operacao);
            out.writeObject(obj);
            out.flush();
            Object resposta = in.readObject();
            return resposta instanceof String && resposta.equals("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Object requisitarObjeto(String operacao, Object parametro) {
        try {
            out.writeObject(operacao);
            out.writeObject(parametro);
            out.flush();
            return in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Object requisitarLista(String operacao) {
        try {
            out.writeObject(operacao);
            out.flush();
            return in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        private Object requisitarListaVeiculos(String operacao, int clienteId) {
        try {
            out.writeObject(operacao);
            out.flush();
            return in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
