package model;

import modelDominio.Veiculo;
import modelDominio.Cliente;
import factory.Conector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    public void insert(Veiculo v) throws SQLException {
        String sql = "INSERT INTO Veiculo (placa, marca, modelo, cor, ano, cliente_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, v.getPlaca());
            ps.setString(2, v.getMarca());
            ps.setString(3, v.getModelo());
            ps.setString(4, v.getCor());
            ps.setInt(5, v.getAno());
            if (v.getCliente() != null) {
                ps.setInt(6, v.getCliente().getId());
            } else {
                ps.setNull(6, Types.INTEGER);
            }
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    v.setId(rs.getInt(1));
                }
            }
        }
    }

    public void update(Veiculo v) throws SQLException {
        String sql = "UPDATE Veiculo SET placa=?, marca=?, modelo=?, cor=?, ano=?, cliente_id=? WHERE id=?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, v.getPlaca());
            ps.setString(2, v.getMarca());
            ps.setString(3, v.getModelo());
            ps.setString(4, v.getCor());
            ps.setInt(5, v.getAno());
            if (v.getCliente() != null) {
                ps.setInt(6, v.getCliente().getId());
            } else {
                ps.setNull(6, Types.INTEGER);
            }
            ps.setInt(7, v.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Veiculo WHERE id = ?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Veiculo findById(int id) throws SQLException {
        String sql = "SELECT * FROM Veiculo WHERE id = ?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = null;
                    int clienteId = rs.getInt("cliente_id");
                    if (!rs.wasNull()) {
                        // opcional: buscar Cliente via ClienteDAO
                        ClienteDAO cdao = new ClienteDAO();
                        cliente = cdao.findById(clienteId);
                    }
                    Veiculo v = new Veiculo(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("cor"),
                        rs.getInt("ano"),
                        cliente
                    );
                    return v;
                }
            }
        }
        return null;
    }
    
    public List<Veiculo> findByCliente(int id) throws SQLException {
        String sql = "SELECT * FROM Veiculo WHERE cliente_id = ?";
        List<Veiculo> lista = new ArrayList<>();
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = null;
                    int clienteId = rs.getInt("cliente_id");
                    if (!rs.wasNull()) {
                        ClienteDAO cdao = new ClienteDAO();
                        cliente = cdao.findById(clienteId);
                    }
                    Veiculo v = new Veiculo(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("cor"),
                        rs.getInt("ano"),
                        cliente
                    );
                    lista.add(v);
                }
            }
        }
        return lista;
    }

    public List<Veiculo> findAll() throws SQLException {
        String sql = "SELECT * FROM Veiculo";
        List<Veiculo> lista = new ArrayList<>();
        try (Connection conn = Conector.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = null;
                int clienteId = rs.getInt("cliente_id");
                if (!rs.wasNull()) {
                    ClienteDAO cdao = new ClienteDAO();
                    cliente = cdao.findById(clienteId);
                }
                Veiculo v = new Veiculo(
                    rs.getInt("id"),
                    rs.getString("placa"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("cor"),
                    rs.getInt("ano"),
                    cliente
                );
                lista.add(v);
            }
        }
        return lista;
    }
}
