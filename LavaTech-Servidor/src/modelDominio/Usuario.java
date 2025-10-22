package modelDominio;

import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 123456789L;

    private int id;
    private String nome;
    private String email;
    private String senhaHash;
    private boolean isAdmin;

    // Construtor completo (SELECT, UPDATE)
    public Usuario(int id, String nome, String email, String senhaHash, boolean isAdmin) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.isAdmin = isAdmin;
    }

    // Construtor sem id (INSERT)
    public Usuario(String nome, String email, String senhaHash, boolean isAdmin) {
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.isAdmin = isAdmin;
    }

    // Construtor somente com id (DELETE)
    public Usuario(int id) {
        this.id = id;
    }

    // Construtor para login (login + senha)
    public Usuario(String email, String senhaHash) {
        this.email = email;
        this.senhaHash = senhaHash;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String login) { this.email = email; }

    public String getSenhaHash() { return senhaHash; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }
    
    public boolean getIsAdmin() { return isAdmin; }
    public void setIsAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senhaHash='" + senhaHash + '\'' +
                ", isAdmin='" + isAdmin +'\''+
                '}';
    }
}
