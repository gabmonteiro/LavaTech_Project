package view;

import modelDominio.Usuario;

public class TelaCriarUsuario extends javax.swing.JFrame {
    
    private Usuario user;
    private Usuario userLogado;

    public TelaCriarUsuario(Usuario userLogado) {
        initComponents();
        this.userLogado = userLogado;
        setVisibleAdmin();
    }
    
    public TelaCriarUsuario(Usuario userLogado, Usuario user) {
        initComponents();
        this.userLogado = userLogado;
        setVisibleAdmin();
        //populando campos com usr edit
        this.user = user;
        preencheForm();
    }
    
    public void preencheForm() {
        nomeField.setText(user.getNome());
        emailField.setText(user.getEmail());
        senhaField.setText(user.getSenhaHash());
        if(userLogado.getIsAdmin()) {
           checkBoxAdmin.setSelected(user.getIsAdmin());
        }
    }
    
    public void setVisibleAdmin() {
        if(!userLogado.getIsAdmin()) {
            checkBoxAdmin.setVisible(false);
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnVoltar1 = new javax.swing.JButton();
        jBtnAdicionar2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        senhaField = new javax.swing.JPasswordField();
        checkBoxAdmin = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel1.setText("Nome:");

        jLabel2.setText("Email:");

        jLabel3.setText("Senha:");

        senhaField.setText("jPasswordField1");

        checkBoxAdmin.setText("É administrador?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(jBtnVoltar1)
                .addGap(59, 59, 59)
                .addComponent(jBtnAdicionar2)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(senhaField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(nomeField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailField, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(checkBoxAdmin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(checkBoxAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAdicionar2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltar1ActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnVoltar1ActionPerformed

    private void jBtnAdicionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionar2ActionPerformed
        Usuario userEnviado;
        String senha = new String(senhaField.getPassword());
        if(user != null) {
            userEnviado = new Usuario(user.getId(),
                    nomeField.getText(),
                    emailField.getText(),
                    senha,
                    checkBoxAdmin.isSelected());
        } else {
            userEnviado = new Usuario(nomeField.getText(),
                    emailField.getText(),
                    senha,
                    checkBoxAdmin.isSelected());
        }
        
        Principal
    }//GEN-LAST:event_jBtnAdicionar2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxAdmin;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jBtnAdicionar2;
    private javax.swing.JButton jBtnVoltar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomeField;
    private javax.swing.JPasswordField senhaField;
    // End of variables declaration//GEN-END:variables
}
