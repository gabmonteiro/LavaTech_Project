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
            
            // Tratamento para objetos que podem ser null
            if (a.getCliente() != null) {
                ps.setInt(3, a.getCliente().getId());
            } else {
                ps.setNull(3, Types.INTEGER);
            }
            if (a.getVeiculo() != null) {
                ps.setInt(4, a.getVeiculo().getId());
            } else {
                ps.setNull(4, Types.INTEGER);
            }
            if (a.getFuncionario() != null) {
                ps.setInt(5, a.getFuncionario().getId());
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            if (a.getServico() != null) {
                ps.setInt(6, a.getServico().getId());
            } else {
                ps.setNull(6, Types.INTEGER);
            }
            
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
                    Cliente cliente = null;
                    Veiculo veiculo = null;
                    Funcionario funcionario = null;
                    Servico servico = null;
                    
                    try {
                        int clienteId = rs.getInt("cliente_id");
                        if (!rs.wasNull()) {
                            cliente = new ClienteDAO().findById(clienteId);
                        }
                    } catch (Exception e) {
                        System.err.println("Erro ao buscar cliente para agendamento ID " + id + ": " + e.getMessage());
                    }
                    
                    try {
                        int veiculoId = rs.getInt("veiculo_id");
                        if (!rs.wasNull()) {
                            veiculo = new VeiculoDAO().findById(veiculoId);
                        }
                    } catch (Exception e) {
                        System.err.println("Erro ao buscar veículo para agendamento ID " + id + ": " + e.getMessage());
                    }
                    
                    try {
                        int funcionarioId = rs.getInt("funcionario_id");
                        if (!rs.wasNull()) {
                            funcionario = new FuncionarioDAO().findById(funcionarioId);
                        }
                    } catch (Exception e) {
                        System.err.println("Erro ao buscar funcionário para agendamento ID " + id + ": " + e.getMessage());
                    }
                    
                    try {
                        int servicoId = rs.getInt("servico_id");
                        if (!rs.wasNull()) {
                            servico = new ServicoDAO().findById(servicoId);
                        }
                    } catch (Exception e) {
                        System.err.println("Erro ao buscar serviço para agendamento ID " + id + ": " + e.getMessage());
                    }

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
        String sql = "SELECT * FROM Agendamento ORDER BY dataHora DESC";
        List<Agendamento> lista = new ArrayList<>();
        try (Connection conn = Conector.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                try {
                    int agendamentoId = rs.getInt("id");
                    Cliente cliente = null;
                    Veiculo veiculo = null;
                    Funcionario funcionario = null;
                    Servico servico = null;
                    
                    try {
                        int clienteId = rs.getInt("cliente_id");
                        if (!rs.wasNull()) {
                            cliente = new ClienteDAO().findById(clienteId);
                        }
                    } catch (Exception e) {
                        System.err.println("Erro ao buscar cliente para agendamento ID " + agendamentoId + ": " + e.getMessage());
                    }
                    
                    try {
                        int veiculoId = rs.getInt("veiculo_id");
                        if (!rs.wasNull()) {
                            veiculo = new VeiculoDAO().findById(veiculoId);
                        }
                    } catch (Exception e) {
                        System.err.println("Erro ao buscar veículo para agendamento ID " + agendamentoId + ": " + e.getMessage());
                    }
                    
                    try {
                        int funcionarioId = rs.getInt("funcionario_id");
                        if (!rs.wasNull()) {
                            funcionario = new FuncionarioDAO().findById(funcionarioId);
                        }
                    } catch (Exception e) {
                        System.err.println("Erro ao buscar funcionário para agendamento ID " + agendamentoId + ": " + e.getMessage());
                    }
                    
                    try {
                        int servicoId = rs.getInt("servico_id");
                        if (!rs.wasNull()) {
                            servico = new ServicoDAO().findById(servicoId);
                        }
                    } catch (Exception e) {
                        System.err.println("Erro ao buscar serviço para agendamento ID " + agendamentoId + ": " + e.getMessage());
                    }

                    LocalDateTime dt = rs.getTimestamp("dataHora").toLocalDateTime();

                    Agendamento a = new Agendamento(
                        agendamentoId,
                        dt,
                        rs.getString("status"),
                        cliente,
                        veiculo,
                        funcionario,
                        servico
                    );
                    lista.add(a);
                } catch (Exception e) {
                    System.err.println("Erro ao carregar agendamento ID " + rs.getInt("id") + ": " + e.getMessage());
                    e.printStackTrace();
                    // Continua para o próximo registro mesmo se houver erro
                }
            }
        }
        return lista;
    }
}
