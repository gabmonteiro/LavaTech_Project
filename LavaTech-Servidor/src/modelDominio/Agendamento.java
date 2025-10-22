package modelDominio;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Agendamento implements Serializable {
    private static final long serialVersionUID = 5L;

    private int id;
    private LocalDateTime dataHora;
    private String status;
    private Cliente cliente;
    private Veiculo veiculo;
    private Funcionario funcionario;
    private Servico servico;

    public Agendamento(int id, LocalDateTime dataHora, String status, Cliente cliente, Veiculo veiculo, Funcionario funcionario, Servico servico) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.funcionario = funcionario;
        this.servico = servico;
    }

    public Agendamento(LocalDateTime dataHora, String status, Cliente cliente, Veiculo veiculo, Funcionario funcionario, Servico servico) {
        this.dataHora = dataHora;
        this.status = status;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.funcionario = funcionario;
        this.servico = servico;
    }

    public Agendamento(int id) {
        this.id = id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }

    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", dataHora=" + dataHora +
                ", status='" + status + '\'' +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", funcionario=" + funcionario +
                ", servico=" + servico +
                '}';
    }
}
