package com.example.projetolavatech.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConexaoController {
    private static ConexaoController instance;

    private Socket cliente;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    // o executar é usado para realizae operaçoes em threads separadas
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    // estado de conexao, inicia com desconectado
    private volatile EstadoConexao estado = EstadoConexao.DESCONECTADO;

    private ConexaoController() {}
        public static synchronized ConexaoController getInstance() {
            if (instance == null){
                instance = new ConexaoController();
            }
            return instance;
        }

        // estados possiveis da conexao
    public enum EstadoConexao {
        DESCONECTADO,
            CONECTANDO,
            CONECTADO,
            ERRO
        }
    public void executar(Runnable onSucess, Runnable onError) {

        // se ja estiver conectado ele apenas ira rodar o sucesso
        if (estado == EstadoConexao.CONECTADO){
            if (onSucess!= null)onSucess.run();
            return;
        }
        if (estado == EstadoConexao.CONECTANDO) {return; }
        estado = EstadoConexao.CONECTANDO;

    executor.execute(() -> {
        try {
            cliente = new Socket("localhost","12345"); // ip e porta do server
            out = new ObjectOutputStream(cliente.getOutputStream());
            in = new ObjectInputStream(cliente.getInputStream());

            estado = EstadoConexao.CONECTADO;
            if (onSucess != null) onSucess.run(); // roda o sucesso
        } catch (IOException e) {
            e.printStackTrace();
            estado = EstadoConexao.ERRO;
            if (onError != null) onError.run(); // roda o erro
        }
    });
    }
    public void desconectar () {
        estado = EstadoConexao.DESCONECTADO;
        executor.execute(() -> {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (cliente != null) cliente.close();
        } catch (IOException e) {
                e.printStackTrace();
        }
        });
    }0
     // metodo que chama as telas
    public Future <Usuario> usuarioLogin(Usuario user){
        Callable <Usuario> usuarioLogar = () -> {
            if (estado != EstadoConexao.CONECTADO){
                throw new IllegalStateException("Cliente não está Conectado");
            }
            out.writeObject("UsuarioLogin");
            out.flush(); // limpa e envia o writeObject
            in.readObject();
            out.writeObject(user);
            out.flush(); // limpa e envia o writeObject
            return (Usuario) in.readObject();
        };
        // onde a operacao vai ser executada
        return executor.submit(usuarioLogar);
    }
}
