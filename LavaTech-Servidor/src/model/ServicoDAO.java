package model;

import factory.Conector;
import modelDominio.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    public void insert(Servico s) throws SQLException {
        String sql = "INSERT INTO Servico (nome, descricao, preco, duracaoEstimadaMin) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, s.getNome());
            ps.setString(2, s.getDescricao());
            ps.setFloat(3, s.getPreco());
            ps.setInt(4, s.getDuracaoEstimadaMin());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    s.setId(rs.getInt(1));
                }
            }
        }
    }

    public void update(Servico s) throws SQLException {
        String sql = "UPDATE Servico SET nome=?, descricao=?, preco=?, duracaoEstimadaMin=? WHERE id=?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getNome());
            ps.setString(2, s.getDescricao());
            ps.setFloat(3, s.getPreco());
            ps.setInt(4, s.getDuracaoEstimadaMin());
            ps.setInt(5, s.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Servico WHERE id = ?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Servico findById(int id) throws SQLException {
        String sql = "SELECT * FROM Servico WHERE id = ?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Servico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getFloat("preco"),
                        rs.getInt("duracaoEstimadaMin")
                    );
                }
            }
        }
        return null;
    }

    public List<Servico> findAll() throws SQLException {
        String sql = "SELECT * FROM Servico";
        List<Servico> lista = new ArrayList<>();
        try (Connection conn = Conector.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Servico s = new Servico(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getFloat("preco"),
                    rs.getInt("duracaoEstimadaMin")
                );
                lista.add(s);
            }
        }
        return lista;
    }
}
