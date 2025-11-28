package view;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelDominio.Usuario;
import view.utils.UIStyle;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
        applyStyles();
        // escondendo o label de aviso
        jLblAviso.setVisible(false);
    }
    
    private void applyStyles() {
        // Aplicar estilos
        UIStyle.setFrameBackground(this);
        UIStyle.styleLabel(jLabel1);
        UIStyle.styleLabel(jLabel2);
        UIStyle.styleTextField(jTextEmail);
        UIStyle.stylePasswordField(jTextSenha);
        UIStyle.stylePrimaryButton(jBtnEntrar);
        UIStyle.styleSecondaryButton(jBtnSair);
        
        // Estilo do título
        jLblTitulo.setFont(UIStyle.FONT_TITLE);
        jLblTitulo.setForeground(UIStyle.TEXT_PRIMARY);
        
        // Estilo do aviso
        jLblAviso.setFont(UIStyle.FONT_LABEL);
        jLblAviso.setForeground(UIStyle.DANGER_COLOR);
        
        // Painel central com fundo branco
        jPanelCard.setBackground(UIStyle.CARD_COLOR);
        jPanelCard.setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.LineBorder(UIStyle.BORDER_COLOR, 1, true),
            new javax.swing.border.EmptyBorder(40, 40, 40, 40)
        ));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCard = new javax.swing.JPanel();
        jLblLogo = new javax.swing.JLabel();
        jLblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jTextSenha = new javax.swing.JPasswordField();
        jBtnEntrar = new javax.swing.JButton();
        jBtnSair = new javax.swing.JButton();
        jLblAviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LavaTech - Login");
        setResizable(false);

        jPanelCard.setBackground(new java.awt.Color(255, 255, 255));

        // Carregar logo
        try {
            java.net.URL logoUrl = getClass().getResource("/view/imagens/logo_lavatech.png");
            if (logoUrl != null) {
                javax.swing.ImageIcon logoIcon = new javax.swing.ImageIcon(logoUrl);
                // Redimensionar para 150x130 (proporção similar ao mobile)
                java.awt.Image img = logoIcon.getImage().getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH);
                jLblLogo.setIcon(new javax.swing.ImageIcon(img));
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar logo: " + e.getMessage());
        }
        jLblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("LavaTech");
        jLblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("E-mail:");

        jLabel2.setText("Senha:");

        jTextEmail.setPreferredSize(new java.awt.Dimension(300, 40));
        jTextEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEntrarActionPerformed(evt);
            }
        });

        jTextSenha.setPreferredSize(new java.awt.Dimension(300, 40));
        jTextSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEntrarActionPerformed(evt);
            }
        });

        jBtnEntrar.setText("Entrar");
        jBtnEntrar.setPreferredSize(new java.awt.Dimension(140, 45));
        jBtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEntrarActionPerformed(evt);
            }
        });

        jBtnSair.setText("Cancelar");
        jBtnSair.setPreferredSize(new java.awt.Dimension(140, 45));
        jBtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairActionPerformed(evt);
            }
        });

        jLblAviso.setForeground(new java.awt.Color(231, 76, 60));
        jLblAviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblAviso.setText("Usuário ou senha inválidos!");

        javax.swing.GroupLayout jPanelCardLayout = new javax.swing.GroupLayout(jPanelCard);
        jPanelCard.setLayout(jPanelCardLayout);
        jPanelCardLayout.setHorizontalGroup(
            jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCardLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelCardLayout.createSequentialGroup()
                        .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelCardLayout.createSequentialGroup()
                        .addComponent(jBtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jBtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        jPanelCardLayout.setVerticalGroup(
            jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLblLogo)
                .addGap(10, 10, 10)
                .addComponent(jLblTitulo)
                .addGap(10, 10, 10)
                .addComponent(jLblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanelCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(700, 600));
        setSize(new java.awt.Dimension(700, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnSairActionPerformed

    private void jBtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEntrarActionPerformed
        try {
            // Lendo os campos da tela
            String email = jTextEmail.getText();
            String senha = new String(jTextSenha.getPassword());

            // Criptografando a senha digitada (mesmo algoritmo do cadastro)
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(senha.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", 0xFF & b));
            }
            String senhaHash = sb.toString();

            // Chamando o método de login com a senha criptografada
            Usuario userLogado = Principal.ccont.login(email, senhaHash);

            if (userLogado != null) {
                // Usuário existe
                Principal.ccont.setUserLogado(userLogado);

                // Abre a tela principal
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);

                // Fecha a tela de login
                dispose();
            } else {
                // Usuário não encontrado
                jLblAviso.setVisible(true);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao criptografar senha: " + e.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnEntrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEntrar;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLblAviso;
    private javax.swing.JLabel jLblLogo;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanelCard;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JPasswordField jTextSenha;
    // End of variables declaration//GEN-END:variables
}
