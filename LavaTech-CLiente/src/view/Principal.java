/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ConexaoController;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author herrmann
 */
public class Principal {
    
    // objeto estático que poderá ser chamado de qualquer tela.
    public static ConexaoController ccont;
    
    public static void main(String[] args) {
        try {
            //criar uma conex;ao com o servidor
            Socket cliente = new Socket("127.0.0.1",12345);
            // Criar o objeto OUT para enviar comandos para o servidor
            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
            // criar o IN, que recebe coisas do Servidor
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
            
            // Voltaremos para cá quando implementarmos a tela de login e classe 
            // respons[avel por se comunicar com o servidor.
            ccont = new ConexaoController(out, in);
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
