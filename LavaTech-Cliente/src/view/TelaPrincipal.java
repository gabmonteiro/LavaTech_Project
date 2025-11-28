package view;

import modelDominio.Usuario;
import view.utils.UIStyle;

public class TelaPrincipal extends javax.swing.JFrame {
    
    private Usuario userLogado;

    public TelaPrincipal() {
        initComponents();
        applyStyles();
        userLogado = Principal.ccont.getUserLogado();
        if (!userLogado.getIsAdmin()){
            jBtnUsuarios.setVisible(false);
            botaoFuncionários.setVisible(false);
        }
    }
    
    private void applyStyles() {
        UIStyle.setFrameBackground(this);
        UIStyle.stylePrimaryButton(jBtnServicos);
        UIStyle.stylePrimaryButton(jBtnAgendamentos);
        UIStyle.stylePrimaryButton(jBtnClientes);
        UIStyle.stylePrimaryButton(botaoFuncionários);
        UIStyle.stylePrimaryButton(jBtnUsuarios);
        UIStyle.styleDangerButton(jBtnSair);
        
        jLblTitulo.setFont(UIStyle.FONT_TITLE);
        jLblTitulo.setForeground(UIStyle.TEXT_PRIMARY);
        
        jLblSubtitulo.setFont(UIStyle.FONT_LABEL);
        jLblSubtitulo.setForeground(UIStyle.TEXT_SECONDARY);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCard = new javax.swing.JPanel();
        jLblTitulo = new javax.swing.JLabel();
        jLblSubtitulo = new javax.swing.JLabel();
        jBtnServicos = new javax.swing.JButton();
        botaoFuncionários = new javax.swing.JButton();
        jBtnAgendamentos = new javax.swing.JButton();
        jBtnClientes = new javax.swing.JButton();
        jBtnSair = new javax.swing.JButton();
        jBtnUsuarios = new javax.swing.JButton();
        jLblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LavaTech - Menu Principal");
        setResizable(false);
        
        // Carregar logo pequena no canto superior direito
        javax.swing.JLabel logoLabel = view.utils.LogoHelper.createLogoLabel(80, 70);
        if (logoLabel != null) {
            jLblLogo = logoLabel;
        }

        jPanelCard.setBackground(new java.awt.Color(255, 255, 255));

        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("LavaTech");
        jLblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLblSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblSubtitulo.setText("Sistema de Gestão de Lavagem de Veículos");
        jLblSubtitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jBtnServicos.setText("Serviços");
        jBtnServicos.setPreferredSize(new java.awt.Dimension(0, 50));
        jBtnServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnServicosActionPerformed(evt);
            }
        });

        botaoFuncionários.setText("Funcionários");
        botaoFuncionários.setPreferredSize(new java.awt.Dimension(0, 50));
        botaoFuncionários.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFuncionáriosActionPerformed(evt);
            }
        });

        jBtnAgendamentos.setText("Agendamentos");
        jBtnAgendamentos.setPreferredSize(new java.awt.Dimension(0, 50));
        jBtnAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgendamentosActionPerformed(evt);
            }
        });

        jBtnClientes.setText("Clientes");
        jBtnClientes.setPreferredSize(new java.awt.Dimension(0, 50));
        jBtnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClientesActionPerformed(evt);
            }
        });

        jBtnSair.setText("Sair");
        jBtnSair.setPreferredSize(new java.awt.Dimension(0, 50));
        jBtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairActionPerformed(evt);
            }
        });

        jBtnUsuarios.setText("Usuários");
        jBtnUsuarios.setPreferredSize(new java.awt.Dimension(0, 50));
        jBtnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCardLayout = new javax.swing.GroupLayout(jPanelCard);
        jPanelCard.setLayout(jPanelCardLayout);
        jPanelCardLayout.setHorizontalGroup(
            jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCardLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnServicos, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jBtnAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoFuncionários, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanelCardLayout.setVerticalGroup(
            jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCardLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLblTitulo)
                .addGap(5, 5, 5)
                .addComponent(jLblSubtitulo)
                .addGap(30, 30, 30)
                .addComponent(jBtnServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jBtnAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jBtnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(botaoFuncionários, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jBtnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jBtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanelCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLblLogo)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanelCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLblLogo)))
                .addGap(50, 50, 50))
        );

        pack();
        setMinimumSize(new java.awt.Dimension(600, 650));
        setPreferredSize(new java.awt.Dimension(600, 650));
        setSize(new java.awt.Dimension(600, 650));
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

    private void jBtnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClientesActionPerformed
        TelaListaClientes telaClientes = new TelaListaClientes();
        telaClientes.setVisible(true);
    }//GEN-LAST:event_jBtnClientesActionPerformed

    private void jBtnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUsuariosActionPerformed
        TelaListaUsuarios telaUsuarios = new TelaListaUsuarios(userLogado);
        telaUsuarios.setVisible(true);
    }//GEN-LAST:event_jBtnUsuariosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFuncionários;
    private javax.swing.JButton jBtnAgendamentos;
    private javax.swing.JButton jBtnClientes;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JButton jBtnServicos;
    private javax.swing.JButton jBtnUsuarios;
    private javax.swing.JLabel jLblLogo;
    private javax.swing.JLabel jLblSubtitulo;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanelCard;
    // End of variables declaration//GEN-END:variables
}
