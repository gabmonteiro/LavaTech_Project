package factory;

import java.sql.*;

public class Conector {
    // objeto que guarda a conexão com o banco de dados.
    private static Connection con;
    
    //método que faz a conexão com o banco de dados
    // além disso, devolve a conexão para o método que o chamou
    public static Connection getConnection(){
        try {
            // Carregar o driver MySQL explicitamente
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Configurações de conexão
            String usuario = "root";
            // Sem senha configurada
            String senha = "";
            
            String url = "jdbc:mysql://localhost:3306/lavatechdb?useSSL=false&serverTimezone=UTC";
            
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            return con;
            
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: Driver MySQL não encontrado!");
            System.err.println("Verifique se o arquivo mysql-connector-j-9.3.0.jar está no classpath.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados:");
            System.err.println("Mensagem: " + e.getMessage());
            System.err.println("Código SQL: " + e.getSQLState());
            System.err.println("Verifique:");
            System.err.println("  1. Se o MariaDB está rodando no Docker");
            System.err.println("  2. Se a porta 3306 está acessível");
            System.err.println("  3. Se o usuário e senha estão corretos");
            System.err.println("  4. Se o banco 'lavatechdb' existe");
            e.printStackTrace();
            return null;
        }
    }    
}
