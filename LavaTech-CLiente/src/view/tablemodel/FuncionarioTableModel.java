package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Funcionario;

public class FuncionarioTableModel extends AbstractTableModel {

    private ArrayList<Funcionario> lista;

    public FuncionarioTableModel(ArrayList<Funcionario> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3; // id, nome, cargo
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario f = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return f.getId();
            case 1: return f.getNome();
            case 2: return f.getCargo();
            default: return "NONE";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Nome";
            case 2: return "Cargo";
            default: return "NONE";
        }
    }

    public Funcionario getFuncionario(int linha) {
        return lista.get(linha);
    }
}
