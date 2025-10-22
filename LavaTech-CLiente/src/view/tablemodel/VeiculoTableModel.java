package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Veiculo;

public class VeiculoTableModel extends AbstractTableModel {

    private ArrayList<Veiculo> lista;

    public VeiculoTableModel(ArrayList<Veiculo> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7; // id, placa, marca, modelo, cor, ano, cliente
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo v = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return v.getId();
            case 1: return v.getPlaca();
            case 2: return v.getMarca();
            case 3: return v.getModelo();
            case 4: return v.getCor();
            case 5: return v.getAno();
            case 6: return v.getCliente() != null ? v.getCliente().getNome() : "—";
            default: return "NONE";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Placa";
            case 2: return "Marca";
            case 3: return "Modelo";
            case 4: return "Cor";
            case 5: return "Ano";
            case 6: return "Cliente";
            default: return "NONE";
        }
    }

    public Veiculo getVeiculo(int linha) {
        return lista.get(linha);
    }
}
