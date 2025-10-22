package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Cliente;

public class ClienteTableModel extends AbstractTableModel {

    private ArrayList<Cliente> lista;

    public ClienteTableModel(ArrayList<Cliente> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3; // id, nome, telefone
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente c = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return c.getId();
            case 1: return c.getNome();
            case 2: return c.getTelefone();
            default: return "NONE";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Nome";
            case 2: return "Telefone";
            default: return "NONE";
        }
    }

    public Cliente getCliente(int linha) {
        return lista.get(linha);
    }
}
