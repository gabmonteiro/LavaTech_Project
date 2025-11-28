package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelDominio.Cliente;
import view.tablemodel.ClienteTableModel;
import view.utils.UIStyle;

public class TelaListaClientes extends javax.swing.JFrame {

    public TelaListaClientes() {
        initComponents();
        applyStyles();
        atualizaTabela();
        setTitle("LavaTech - Clientes");
    }
    
    private void applyStyles() {
        UIStyle.setFrameBackground(this);
        UIStyle.setPanelBackground(jPanel1);
        UIStyle.styleSecondaryButton(jBtnVoltar1);
        UIStyle.styleSecondaryButton(jBtnAtualizar);
        UIStyle.stylePrimaryButton(jBtnAdicionar2);
        UIStyle.stylePrimaryButton(jBtnEditar);
        UIStyle.styleDangerButton(jBtnExcluir);
        UIStyle.styleSecondaryButton(jBtnVeiculos);
        UIStyle.styleTable(jTableClientes);
        
        jLblTitulo.setFont(UIStyle.FONT_SUBTITLE);
        jLblTitulo.setForeground(UIStyle.TEXT_PRIMARY);
    }

    public void atualizaTabela() {
        ArrayList<Cliente> lista = Principal.ccont.listarClientes();
        ClienteTableModel clienteTableModel = new ClienteTableModel(lista);
        jTableClientes.setModel(clienteTableModel);
        UIStyle.styleTable(jTableClientes);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBtnAtualizar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnVoltar1 = new javax.swing.JButton();
        jBtnAdicionar2 = new javax.swing.JButton();
        jBtnVeiculos = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jLblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LavaTech - Clientes");
        
        // Carregar logo pequena no canto superior direito
        javax.swing.JLabel logoLabel = view.utils.LogoHelper.createLogoLabel(80, 70);
        if (logoLabel != null) {
            jLblLogo = logoLabel;
        }

        jLblTitulo = new javax.swing.JLabel();
        jLblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLblTitulo.setText("Clientes");
        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jBtnAtualizar.setText("Atualizar");
        jBtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAtualizarActionPerformed(evt);
            }
        });

        jBtnEditar.setText("Editar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnVoltar1.setText("Voltar");
        jBtnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltar1ActionPerformed(evt);
            }
        });

        jBtnAdicionar2.setText("Adicionar");
        jBtnAdicionar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionar2ActionPerformed(evt);
            }
        });

        jBtnVeiculos.setText("Veículos");
        jBtnVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVeiculosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnVoltar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnVeiculos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnAdicionar2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAdicionar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLblLogo)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLblLogo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
        );

        pack();
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setSize(new java.awt.Dimension(1000, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAtualizarActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_jBtnAtualizarActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        int linhaSelecionada = jTableClientes.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para atualizar.");
            return;
        }

        // Pegando o modelo da tabela
        ClienteTableModel model = ( ClienteTableModel) jTableClientes.getModel();
        Cliente  clienteSelecionado = model.getCliente(linhaSelecionada);

        // Chamando a tela de atualização com o ID (CRIAR TELA DE CREATE)
        TelaCriarCliente telaAtCliente = new TelaCriarCliente(clienteSelecionado, this);
        telaAtCliente.setVisible(true);
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        int linhaSelecionada = jTableClientes.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para atualizar.");
            return;
        }

        // Pegando o modelo da tabela
        ClienteTableModel model = ( ClienteTableModel) jTableClientes.getModel();
        Cliente  clienteSelecionado = model.getCliente(linhaSelecionada);

        if(Principal.ccont.excluirCliente(clienteSelecionado.getId())) {
            JOptionPane.showMessageDialog(this, "Cliente removido!");
        } else {
            JOptionPane.showMessageDialog(this, "Cliente não removido!");
        }
        atualizaTabela();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltar1ActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnVoltar1ActionPerformed

    private void jBtnAdicionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionar2ActionPerformed
        // Chamando a tela de atualização com o ID (CRIAR TELA DE CREATE)
        TelaCriarCliente telaAtCliente = new TelaCriarCliente(this);
        telaAtCliente.setVisible(true);
    }//GEN-LAST:event_jBtnAdicionar2ActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        if (evt.getClickCount() == 2) {
            int linhaSelecionada = jTableClientes.getSelectedRow();

            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um cliente para atualizar.");
                return;
            }

        // Pegando o modelo da tabela
        ClienteTableModel model = ( ClienteTableModel) jTableClientes.getModel();
        Cliente  clienteSelecionado = model.getCliente(linhaSelecionada);

        // Chamando a tela de atualização com o ID (CRIAR TELA DE CREATE)
        TelaCriarCliente telaAtCliente = new TelaCriarCliente(clienteSelecionado, this);
        telaAtCliente.setVisible(true);
        }
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void jBtnVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVeiculosActionPerformed
        int linhaSelecionada = jTableClientes.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para listar veículos.");
            return;
        }

        // Pegando o modelo da tabela
        ClienteTableModel model = ( ClienteTableModel) jTableClientes.getModel();
        Cliente  clienteSelecionado = model.getCliente(linhaSelecionada);
        
        TelaListaVeiculos telaListaVeiculos = new TelaListaVeiculos(clienteSelecionado); 
        telaListaVeiculos.setVisible(true);
    }//GEN-LAST:event_jBtnVeiculosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdicionar2;
    private javax.swing.JButton jBtnAtualizar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnVeiculos;
    private javax.swing.JButton jBtnVoltar1;
    private javax.swing.JLabel jLblLogo;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableClientes;
    // End of variables declaration//GEN-END:variables
}
