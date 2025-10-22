package view;

import controller.TrataClienteController;
import factory.Conector;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Principal {
    
    public static void main(String[] args)  {
        // linhas de teste para a conexao com o banco
        if (Conector.getConnection() != null){
            System.out.println("Conexão com o banco de dados efetuada!");
        }
        
        // vamos utilizar estruturas de proteção do código
        // para isso vamos utilizar o try catch
        try {
           // criar o servidor socket
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor socket inicilizado na porta 12345. Aguardando conexões!");
            // variavel para controlar o numero de clientes conectados
            int idUnico = 0;
            // looping que ficara executando para sempre
            while (true){
                // recebendo a conexão do cliente e armazenando 
                // na variável cliente (objeto)
                Socket cliente = servidor.accept();
                System.out.println("Um novo cliente conectou: "+cliente);
                idUnico++;
                //TODO: deveremos criar a nossa thread aqui. Essa thread irá tratar
                //      todos os comandos vindos do clientes
                TrataClienteController trataCliente = new TrataClienteController(cliente, idUnico);
                // iniciar a thread
                trataCliente.start(); // o start executa o método RUN.
            }
            
        } catch (IOException e) {
            System.out.println("Erro: "+ e);
        }
        
    }
    
}
