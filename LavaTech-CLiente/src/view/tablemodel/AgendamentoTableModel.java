package view.tablemodel;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Agendamento;

public class AgendamentoTableModel extends AbstractTableModel {

    private ArrayList<Agendamento> lista;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public AgendamentoTableModel(ArrayList<Agendamento> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7; // id, dataHora, status, cliente, veiculo, funcionario, servico
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Agendamento a = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return a.getId();
            case 1: return a.getDataHora().format(formatter);
            case 2: return a.getStatus();
            case 3: return a.getCliente() != null ? a.getCliente().getNome() : "—";
            case 4: return a.getVeiculo() != null ? a.getVeiculo().getModelo() : "—";
            case 5: return a.getFuncionario() != null ? a.getFuncionario().getNome() : "—";
            case 6: return a.getServico() != null ? a.getServico().getNome() : "—";
            default: return "NONE";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Data/Hora";
            case 2: return "Status";
            case 3: return "Cliente";
            case 4: return "Veículo";
            case 5: return "Funcionário";
            case 6: return "Serviço";
            default: return "NONE";
        }
    }

    // retorna o agendamento da linha selecionada
    public Agendamento getAgendamento(int linha) {
        return lista.get(linha);
    }
}
