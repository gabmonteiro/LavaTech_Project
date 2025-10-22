package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Usuario;

public class UsuarioTableModel extends AbstractTableModel {

    private ArrayList<Usuario> lista;

    public UsuarioTableModel(ArrayList<Usuario> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5; // id, nome, email, senhaHash, isAdmin
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario u = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return u.getId();
            case 1: return u.getNome();
            case 2: return u.getEmail();
            case 3: return u.getSenhaHash();
            case 4: return u.getIsAdmin() ? "Sim" : "Não";
            default: return "NONE";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Nome";
            case 2: return "E-mail";
            case 3: return "Senha Hash";
            case 4: return "Administrador";
            default: return "NONE";
        }
    }

    public Usuario getUsuario(int linha) {
        return lista.get(linha);
    }
}
