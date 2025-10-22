package model;

import modelDominio.Agendamento;
import modelDominio.Cliente;
import modelDominio.Veiculo;
import modelDominio.Funcionario;
import modelDominio.Servico;

import factory.Conector;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {

    public void insert(Agendamento a) throws SQLException {
        String sql = "INSERT INTO Agendamento (dataHora, status, cliente_id, veiculo_id, funcionario_id, servico_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setTimestamp(1, Timestamp.valueOf(a.getDataHora()));
            ps.setString(2, a.getStatus());
            ps.setInt(3, a.getCliente().getId());
            ps.setInt(4, a.getVeiculo().getId());
            ps.setInt(5, a.getFuncionario().getId());
            ps.setInt(6, a.getServico().getId());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    a.setId(rs.getInt(1));
                }
            }
        }
    }

    public void update(Agendamento a) throws SQLException {
        String sql = "UPDATE Agendamento SET dataHora=?, status=?, cliente_id=?, veiculo_id=?, funcionario_id=?, servico_id=? WHERE id=?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(a.getDataHora()));
            ps.setString(2, a.getStatus());
            ps.setInt(3, a.getCliente().getId());
            ps.setInt(4, a.getVeiculo().getId());
            ps.setInt(5, a.getFuncionario().getId());
            ps.setInt(6, a.getServico().getId());
            ps.setInt(7, a.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Agendamento WHERE id = ?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Agendamento findById(int id) throws SQLException {
        String sql = "SELECT * FROM Agendamento WHERE id = ?";
        try (Connection conn = Conector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new ClienteDAO().findById(rs.getInt("cliente_id"));
                    Veiculo veiculo = new VeiculoDAO().findById(rs.getInt("veiculo_id"));
                    Funcionario funcionario = new FuncionarioDAO().findById(rs.getInt("funcionario_id"));
                    Servico servico = new ServicoDAO().findById(rs.getInt("servico_id"));

                    LocalDateTime dt = rs.getTimestamp("dataHora").toLocalDateTime();

                    Agendamento a = new Agendamento(
                        rs.getInt("id"),
                        dt,
                        rs.getString("status"),
                        cliente,
                        veiculo,
                        funcionario,
                        servico
                    );
                    return a;
                }
            }
        }
        return null;
    }

    public List<Agendamento> findAll() throws SQLException {
        String sql = "SELECT * FROM Agendamento";
        List<Agendamento> lista = new ArrayList<>();
        try (Connection conn = Conector.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new ClienteDAO().findById(rs.getInt("cliente_id"));
                Veiculo veiculo = new VeiculoDAO().findById(rs.getInt("veiculo_id"));
                Funcionario funcionario = new FuncionarioDAO().findById(rs.getInt("funcionario_id"));
                Servico servico = new ServicoDAO().findById(rs.getInt("servico_id"));

                LocalDateTime dt = rs.getTimestamp("dataHora").toLocalDateTime();

                Agendamento a = new Agendamento(
                    rs.getInt("id"),
                    dt,
                    rs.getString("status"),
                    cliente,
                    veiculo,
                    funcionario,
                    servico
                );
                lista.add(a);
            }
        }
        return lista;
    }
}
