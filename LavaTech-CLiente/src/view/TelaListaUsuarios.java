package view;

import java.util.ArrayList;
import modelDominio.Usuario;
import view.tablemodel.UsuarioTableModel;

public class TelaListaUsuarios extends javax.swing.JFrame {

    public TelaListaUsuarios() {
        initComponents();
        atualizaTabela();
    }
    
    public void atualizaTabela() {
        ArrayList<Usuario> lista = Principal.ccont.listarUsuarios();
        UsuarioTableModel userTableModel = new UsuarioTableModel(lista);
        jTableUsuarios.setModel(userTableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
