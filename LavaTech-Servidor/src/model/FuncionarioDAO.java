package model;

import modelDominio.Funcionario;
import factory.Conector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void insert(Funcionario f) throws SQLException {
        String sql = "INSERT INTO Funcionario (nome, cargo) VALUES (?, ?)";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, f.getNome());
            ps.setString(2, f.getCargo());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    f.setId(rs.getInt(1));
                }
            }
        }
    }

    public void update(Funcionario f) throws SQLException {
        String sql = "UPDATE Funcionario SET nome=?, cargo=? WHERE id=?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, f.getNome());
            ps.setString(2, f.getCargo());
            ps.setInt(3, f.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Funcionario WHERE id = ?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Funcionario findById(int id) throws SQLException {
        String sql = "SELECT * FROM Funcionario WHERE id = ?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cargo")
                    );
                }
            }
        }
        return null;
    }

    public List<Funcionario> findAll() throws SQLException {
        String sql = "SELECT * FROM Funcionario";
        List<Funcionario> lista = new ArrayList<>();
        try (Connection conn = Conector.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Funcionario f = new Funcionario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cargo")
                );
                lista.add(f);
            }
        }
        return lista;
    }
}
