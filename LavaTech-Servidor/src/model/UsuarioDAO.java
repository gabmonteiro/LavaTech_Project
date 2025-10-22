package model;

import modelDominio.Usuario;
import factory.Conector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void insert(Usuario u) throws SQLException {
        String sql = "INSERT INTO Usuario (nome, email, senhaHash, isAdmin) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenhaHash());
            ps.setBoolean(4, u.getIsAdmin());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    u.setId(rs.getInt(1));
                }
            }
        }
    }

    public void update(Usuario u) throws SQLException {
        String sql = "UPDATE Usuario SET nome=?,email=?, senhaHash=?, isAdmin=? WHERE id=?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenhaHash());
            ps.setBoolean(4, u.getIsAdmin());
            ps.setInt(5, u.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE id = ?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Usuario findById(int id) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE id = ?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senhaHash"),
                        rs.getBoolean("isAdmin")
                    );
                }
            }
        }
        return null;
    }

    public List<Usuario> findAll() throws SQLException {
        String sql = "SELECT * FROM Usuario";
        List<Usuario> lista = new ArrayList<>();
        try (Connection conn = Conector.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senhaHash"),
                    rs.getBoolean("isAdmin")
                );
                lista.add(u);
            }
        }
        return lista;
    }

    // Método adicional: autenticar (login + senhaHash)
    public Usuario autenticar(String email, String senhaHash) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE email = ? AND senhaHash = ?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, senhaHash);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senhaHash"),
                        rs.getBoolean("isAdmin")
                    );
                }
            }
        }
        return null;
    }
}
