package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelDominio.Veiculo;
import view.tablemodel.VeiculoTableModel;

public class TelaListaVeiculos extends javax.swing.JFrame {
    
    private int clienteId;

    public TelaListaVeiculos(int clienteId) {
        this.clienteId = clienteId;
        initComponents();
        atualizaTabela();
    }
    
    public void atualizaTabela() {
        ArrayList<Veiculo> lista = Principal.ccont.listarVeiculosPorCliente(clienteId);
        VeiculoTableModel veiculoTableModel = new VeiculoTableModel(lista);
        jTableVeiculos.setModel(veiculoTableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTableVeiculos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jBtnAtualizar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnVoltar1 = new javax.swing.JButton();
        jBtnAdicionar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVeiculosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableVeiculos);

        jBtnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/voltar.png"))); // NOI18N
        jBtnAtualizar.setText("Atualizar");
        jBtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAtualizarActionPerformed(evt);
            }
        });

        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/adicionar.png"))); // NOI18N
        jBtnEditar.setText("Editar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/adicionar.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnVoltar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/voltar.png"))); // NOI18N
        jBtnVoltar1.setText("Voltar");
        jBtnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltar1ActionPerformed(evt);
            }
        });

        jBtnAdicionar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/adicionar.png"))); // NOI18N
        jBtnAdicionar2.setText("Adicionar");
        jBtnAdicionar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnVoltar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnAtualizar)
                .addGap(18, 18, 18)
                .addComponent(jBtnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnAdicionar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnEditar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jBtnVoltar1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jBtnAdicionar2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVeiculosMouseClicked
        if (evt.getClickCount() == 2) {
            int linhaSelecionada = jTableVeiculos.getSelectedRow();

            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um veiculo para atualizar.");
                return;
            }

            // Pegando o modelo da tabela
            VeiculoTableModel model = ( VeiculoTableModel) jTableVeiculos.getModel();
            Veiculo  veiculoSelecionado = model.getVeiculo(linhaSelecionada);

            // Chamando a tela de atualização com o ID (CRIAR TELA DE CREATE)
            //TelaAtualizarUsuario telaAtUsuario = new TelaAtualizarUsuario(usuarioSelecionado, this);
            //telaAtUsuario.setVisible(true);
        }
    }//GEN-LAST:event_jTableVeiculosMouseClicked

    private void jBtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAtualizarActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_jBtnAtualizarActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        int linhaSelecionada = jTableVeiculos.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um veiculo para atualizar.");
            return;
        }

            // Pegando o modelo da tabela
            VeiculoTableModel model = ( VeiculoTableModel) jTableVeiculos.getModel();
            Veiculo  veiculoSelecionado = model.getVeiculo(linhaSelecionada);

        // Chamando a tela de atualização com o ID (CRIAR TELA DE CREATE)
        //TelaAtualizarUsuario telaAtUsuario = new TelaAtualizarUsuario(usuarioSelecionado, this);
        //telaAtUsuario.setVisible(true);
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        int linhaSelecionada = jTableVeiculos.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um veiculo para atualizar.");
            return;
        }

            // Pegando o modelo da tabela
            VeiculoTableModel model = ( VeiculoTableModel) jTableVeiculos.getModel();
            Veiculo  veiculoSelecionado = model.getVeiculo(linhaSelecionada);

        if(Principal.ccont.excluirUsuario(veiculoSelecionado.getId())) {
            JOptionPane.showMessageDialog(this, "Veiculo removido!");
        } else {
            JOptionPane.showMessageDialog(this, "Veiculo não removido!");
        }
        atualizaTabela();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltar1ActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnVoltar1ActionPerformed

    private void jBtnAdicionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionar2ActionPerformed
        // Chamando a tela de atualização com o ID (CRIAR TELA DE CREATE)
        //TelaAtualizarUsuario telaAtUsuario = new TelaAtualizarUsuario(usuarioSelecionado, this);
        //telaAtUsuario.setVisible(true);
    }//GEN-LAST:event_jBtnAdicionar2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdicionar2;
    private javax.swing.JButton jBtnAtualizar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnVoltar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableVeiculos;
    // End of variables declaration//GEN-END:variables
}
