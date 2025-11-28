package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelDominio.Agendamento;
import view.tablemodel.AgendamentoTableModel;
import view.utils.UIStyle;

public class TelaListaAgendamentos extends javax.swing.JFrame {

    public TelaListaAgendamentos() {
        initComponents();
        applyStyles();
        atualizaTabela();
        setTitle("LavaTech - Agendamentos");
    }
    
    private void applyStyles() {
        UIStyle.setFrameBackground(this);
        UIStyle.setPanelBackground(jPanel1);
        UIStyle.styleSecondaryButton(jBtnVoltar);
        UIStyle.styleSecondaryButton(jBtnAtualizar);
        UIStyle.stylePrimaryButton(jBtnAdicionar);
        UIStyle.stylePrimaryButton(jBtnEditar);
        UIStyle.styleDangerButton(jBtnExcluir);
        UIStyle.styleSuccessButton(jBtnConcluir);
        UIStyle.styleSecondaryButton(jBtnClientes);
        UIStyle.styleTable(jTableAgendamentos);
        
        jLblTitulo.setFont(UIStyle.FONT_SUBTITLE);
        jLblTitulo.setForeground(UIStyle.TEXT_PRIMARY);
    }
    
    public void atualizaTabela() {
        ArrayList<Agendamento> lista = Principal.ccont.listarAgendamentos();
        AgendamentoTableModel agendamentoTableModel = new AgendamentoTableModel(lista);
        jTableAgendamentos.setModel(agendamentoTableModel);
        UIStyle.styleTable(jTableAgendamentos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBtnAtualizar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnVoltar = new javax.swing.JButton();
        jBtnClientes = new javax.swing.JButton();
        jBtnAdicionar = new javax.swing.JButton();
        jBtnConcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgendamentos = new javax.swing.JTable();
        jLblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LavaTech - Agendamentos");
        
        // Carregar logo pequena no canto superior direito
        javax.swing.JLabel logoLabel = view.utils.LogoHelper.createLogoLabel(80, 70);
        if (logoLabel != null) {
            jLblLogo = logoLabel;
        }

        jLblTitulo = new javax.swing.JLabel();
        jLblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLblTitulo.setText("Agendamentos");
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

        jBtnVoltar.setText("Voltar");
        jBtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarActionPerformed(evt);
            }
        });

        jBtnClientes.setText("Clientes");
        jBtnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClientesActionPerformed(evt);
            }
        });

        jBtnAdicionar.setText("Adicionar");
        jBtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionarActionPerformed(evt);
            }
        });

        jBtnConcluir.setText("Concluir");
        jBtnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConcluirActionPerformed(evt);
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
                        .addComponent(jBtnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnConcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnAdicionar)
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
                    .addComponent(jBtnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTableAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAgendamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAgendamentos);

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
            .addComponent(jScrollPane1)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
        );

        pack();
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1100, 700));
        setSize(new java.awt.Dimension(1100, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAtualizarActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_jBtnAtualizarActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        int linhaSelecionada = jTableAgendamentos.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um agendamento para editar.");
            return;
        }

        // Pegando o modelo da tabela
        AgendamentoTableModel model = (AgendamentoTableModel) jTableAgendamentos.getModel();
        Agendamento agendamentoSelecionado = model.getAgendamento(linhaSelecionada);

        // Chamando a tela de edição
        TelaCriarAgendamento telaCriarAgendamento = new TelaCriarAgendamento(agendamentoSelecionado, this);
        telaCriarAgendamento.setVisible(true);
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        int linhaSelecionada = jTableAgendamentos.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um agendamento para excluir.");
            return;
        }

        // Pegando o modelo da tabela
        AgendamentoTableModel model = (AgendamentoTableModel) jTableAgendamentos.getModel();
        Agendamento agendamentoSelecionado = model.getAgendamento(linhaSelecionada);

        int confirmacao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente excluir este agendamento?",
            "Confirmar exclusão",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            if(Principal.ccont.excluirAgendamento(agendamentoSelecionado.getId())) {
                JOptionPane.showMessageDialog(this, "Agendamento removido com sucesso!");
                atualizaTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao remover agendamento!");
            }
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnVoltarActionPerformed

    private void jBtnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClientesActionPerformed
        // Abrir cadastro de clientes
        TelaListaClientes telaClientes = new TelaListaClientes();
        telaClientes.setVisible(true);
    }//GEN-LAST:event_jBtnClientesActionPerformed

    private void jTableAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendamentosMouseClicked
        if (evt.getClickCount() == 2) {
            int linhaSelecionada = jTableAgendamentos.getSelectedRow();

            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um agendamento para editar.");
                return;
            }

            // Pegando o modelo da tabela
            AgendamentoTableModel model = (AgendamentoTableModel) jTableAgendamentos.getModel();
            Agendamento agendamentoSelecionado = model.getAgendamento(linhaSelecionada);

            // Chamando a tela de edição
            TelaCriarAgendamento telaCriarAgendamento = new TelaCriarAgendamento(agendamentoSelecionado, this);
            telaCriarAgendamento.setVisible(true);
        }
    }//GEN-LAST:event_jTableAgendamentosMouseClicked

    private void jBtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarActionPerformed
        // Chamando a tela de criação
        TelaCriarAgendamento telaCriarAgendamento = new TelaCriarAgendamento(this);
        telaCriarAgendamento.setVisible(true);
    }//GEN-LAST:event_jBtnAdicionarActionPerformed

    private void jBtnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConcluirActionPerformed
        int linhaSelecionada = jTableAgendamentos.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um agendamento para concluir.");
            return;
        }

        // Pegando o modelo da tabela
        AgendamentoTableModel model = (AgendamentoTableModel) jTableAgendamentos.getModel();
        Agendamento agendamentoSelecionado = model.getAgendamento(linhaSelecionada);

        // Verificar se já está concluído
        if ("Concluído".equals(agendamentoSelecionado.getStatus())) {
            JOptionPane.showMessageDialog(this, "Este agendamento já está concluído!");
            return;
        }
        
        int confirmacao = JOptionPane.showConfirmDialog(
            this,
            "Deseja marcar este agendamento como concluído?",
            "Confirmar conclusão",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            int agendamentoId = agendamentoSelecionado.getId();
            if(Principal.ccont.concluirAgendamento(agendamentoId)) {
                JOptionPane.showMessageDialog(this, "Agendamento marcado como concluído com sucesso!");
                // Forçar atualização da tabela
                atualizaTabela();
                // Verificar se o agendamento ainda está na lista
                ArrayList<Agendamento> listaAtualizada = Principal.ccont.listarAgendamentos();
                boolean encontrado = false;
                for (Agendamento ag : listaAtualizada) {
                    if (ag.getId() == agendamentoId) {
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.err.println("AVISO: Agendamento ID " + agendamentoId + " não encontrado após atualização!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao concluir agendamento!");
            }
        }
    }//GEN-LAST:event_jBtnConcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdicionar;
    private javax.swing.JButton jBtnAtualizar;
    private javax.swing.JButton jBtnClientes;
    private javax.swing.JButton jBtnConcluir;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnVoltar;
    private javax.swing.JLabel jLblLogo;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAgendamentos;
    // End of variables declaration//GEN-END:variables
}
