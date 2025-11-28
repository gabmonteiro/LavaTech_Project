package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Servico;

public class ServicoTableModel extends AbstractTableModel {

    private ArrayList<Servico> lista;

    public ServicoTableModel(ArrayList<Servico> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5; // id, nome, descricao, preco, duracaoEstimadaMin
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Servico s = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return s.getId();
            case 1: return s.getNome();
            case 2: return s.getDescricao();
            case 3: return s.getPreco();
            case 4: return s.getDuracaoEstimadaMin();
            default: return "NONE";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Nome";
            case 2: return "Descrição";
            case 3: return "Preço (R$)";
            case 4: return "Duração (min)";
            default: return "NONE";
        }
    }

    // retorna o serviço da linha selecionada
    public Servico getServico(int linha) {
        return lista.get(linha);
    }
}
