package view;

import modelDominio.Usuario;

public class TelaPrincipal extends javax.swing.JFrame {
    
    private Usuario userLogado;

    public TelaPrincipal() {
        initComponents();
        userLogado = Principal.ccont.getUserLogado();
        if (!userLogado.getIsAdmin()){
            jBtnUsuarios.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnServicos = new javax.swing.JButton();
        botaoFuncionários = new javax.swing.JButton();
        jBtnAgendamentos = new javax.swing.JButton();
        jBtnUsuarios = new javax.swing.JButton();
        jBtnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBtnServicos.setText("Serviços");
        jBtnServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnServicosActionPerformed(evt);
            }
        });

        botaoFuncionários.setText("Funcionários");
        botaoFuncionários.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFuncionáriosActionPerformed(evt);
            }
        });

        jBtnAgendamentos.setText("Agendamentos");
        jBtnAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgendamentosActionPerformed(evt);
            }
        });

        jBtnUsuarios.setText("Usuários");
        jBtnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUsuariosActionPerformed(evt);
            }
        });

        jBtnSair.setText("Sair");
        jBtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnServicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoFuncionários, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(jBtnAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(jBtnUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(jBtnSair, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jBtnServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoFuncionários, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnSairActionPerformed

    private void jBtnServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnServicosActionPerformed
        TelaListaServicos telaServicos = new TelaListaServicos();
        telaServicos.setVisible(true);
    }//GEN-LAST:event_jBtnServicosActionPerformed
        
    private void botaoFuncionáriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFuncionáriosActionPerformed
        TelaListaFuncionarios telaFuncionarios = new TelaListaFuncionarios();
        telaFuncionarios.setVisible(true);
    }//GEN-LAST:event_botaoFuncionáriosActionPerformed

    private void jBtnAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgendamentosActionPerformed
        TelaListaAgendamentos telaAgendamentos = new TelaListaAgendamentos();
        telaAgendamentos.setVisible(true);
    }//GEN-LAST:event_jBtnAgendamentosActionPerformed

    private void jBtnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUsuariosActionPerformed
        TelaListaUsuarios telaUsuarios = new TelaListaUsuarios();
        telaUsuarios.setVisible(true);
    }//GEN-LAST:event_jBtnUsuariosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFuncionários;
    private javax.swing.JButton jBtnAgendamentos;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JButton jBtnServicos;
    private javax.swing.JButton jBtnUsuarios;
    // End of variables declaration//GEN-END:variables
}
