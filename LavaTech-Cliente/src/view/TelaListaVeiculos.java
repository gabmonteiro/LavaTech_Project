package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelDominio.Cliente;
import modelDominio.Veiculo;
import view.tablemodel.VeiculoTableModel;
import view.utils.UIStyle;

public class TelaListaVeiculos extends javax.swing.JFrame {
    
    private Cliente cliente;

    public TelaListaVeiculos(Cliente cliente) {
        this.cliente = cliente;
        initComponents();
        applyStyles();
        atualizaTabela();
        setTitle("LavaTech - Veículos de " + cliente.getNome());
    }
    
    private void applyStyles() {
        UIStyle.setFrameBackground(this);
        UIStyle.setPanelBackground(jPanel1);
        UIStyle.styleSecondaryButton(jBtnVoltar1);
        UIStyle.styleSecondaryButton(jBtnAtualizar);
        UIStyle.stylePrimaryButton(jBtnAdicionar2);
        UIStyle.stylePrimaryButton(jBtnEditar);
        UIStyle.styleDangerButton(jBtnExcluir);
        UIStyle.styleTable(jTableVeiculos);
        
        jLblTitulo.setFont(UIStyle.FONT_SUBTITLE);
        jLblTitulo.setForeground(UIStyle.TEXT_PRIMARY);
    }
    
    public void atualizaTabela() {
        ArrayList<Veiculo> lista = Principal.ccont.listarVeiculosPorCliente(cliente.getId());
        VeiculoTableModel veiculoTableModel = new VeiculoTableModel(lista);
        jTableVeiculos.setModel(veiculoTableModel);
        UIStyle.styleTable(jTableVeiculos);
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
        jLblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LavaTech - Veículos");
        
        // Carregar logo pequena no canto superior direito
        javax.swing.JLabel logoLabel = view.utils.LogoHelper.createLogoLabel(80, 70);
        if (logoLabel != null) {
            jLblLogo = logoLabel;
        }

        jLblTitulo = new javax.swing.JLabel();
        jLblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLblTitulo.setText("Veículos");
        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
                    .addComponent(jBtnAdicionar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            TelaCriarVeiculo telaAtVeiculo = new TelaCriarVeiculo(cliente, veiculoSelecionado, this);
            telaAtVeiculo.setVisible(true);
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
        TelaCriarVeiculo telaAtVeiculo = new TelaCriarVeiculo(cliente, veiculoSelecionado, this);
        telaAtVeiculo.setVisible(true);
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        int linhaSelecionada = jTableVeiculos.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um veículo para excluir.");
            return;
        }

        // Pegando o modelo da tabela
        VeiculoTableModel model = (VeiculoTableModel) jTableVeiculos.getModel();
        Veiculo veiculoSelecionado = model.getVeiculo(linhaSelecionada);

        int confirmacao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente excluir o veículo \"" + veiculoSelecionado.getModelo() + "\"?",
            "Confirmar exclusão",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            if(Principal.ccont.excluirVeiculo(veiculoSelecionado.getId())) {
                JOptionPane.showMessageDialog(this, "Veículo removido com sucesso!");
                atualizaTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao remover veículo! O veículo pode estar vinculado a um agendamento.");
            }
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltar1ActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnVoltar1ActionPerformed

    private void jBtnAdicionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionar2ActionPerformed
        // Chamando a tela de atualização com o ID (CRIAR TELA DE CREATE)
        TelaCriarVeiculo telaAtVeiculo = new TelaCriarVeiculo(cliente, this);
        telaAtVeiculo.setVisible(true);
    }//GEN-LAST:event_jBtnAdicionar2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdicionar2;
    private javax.swing.JButton jBtnAtualizar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnVoltar1;
    private javax.swing.JLabel jLblLogo;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableVeiculos;
    // End of variables declaration//GEN-END:variables
}
