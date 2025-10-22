package factory;

import java.sql.*;

public class Conector {
    // objeto que guarda a conexão com o banco de dados.
    private static Connection con;
    
    //método que faz a conexão com o banco de dados
    // além disso, devolve a conexão para o método que o chamou
    public static Connection getConnection(){
        try {
            // caminho do banco
            String usuario = "root";
            // senha do windows geralmente é vazio ""
            String senha = "";
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lavatechdb", usuario, senha);
    
            return con;
            
        } catch (SQLException e) {
            return null;
        }
    }    
}
