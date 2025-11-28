package view;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import modelDominio.Usuario;
import view.utils.UIStyle;

public class TelaCriarUsuario extends javax.swing.JFrame {
    
    private Usuario user;
    private Usuario userLogado;
    private TelaListaUsuarios telaLista;

    public TelaCriarUsuario(Usuario userLogado, TelaListaUsuarios telaLista) {
        initComponents();
        applyStyles();
        this.userLogado = userLogado;
        this.telaLista = telaLista;
        setTitle("LavaTech - Novo Usuário");
        
        // Carregar logo pequena no canto superior direito
        javax.swing.JLabel logoLabel = view.utils.LogoHelper.createLogoLabel(80, 70);
        if (logoLabel != null) {
            jLblLogo = logoLabel;
        }
        setVisibleAdmin();
    }
    
    public TelaCriarUsuario(Usuario userLogado, Usuario user, TelaListaUsuarios telaLista) {
        initComponents();
        applyStyles();
        this.userLogado = userLogado;
        this.telaLista = telaLista;
        setTitle("LavaTech - Editar Usuário");
        setVisibleAdmin();
        //populando campos com usr edit
        this.user = user;
        preencheForm();
    }
    
    private void applyStyles() {
        UIStyle.setFrameBackground(this);
        UIStyle.styleLabel(jLabel1);
        UIStyle.styleLabel(jLabel2);
        UIStyle.styleLabel(jLabel3);
        UIStyle.styleTextField(nomeField);
        UIStyle.styleTextField(emailField);
        UIStyle.stylePasswordField(senhaField);
        UIStyle.stylePrimaryButton(jBtnAdicionar2);
        UIStyle.styleSecondaryButton(jBtnVoltar1);
        
        jLblTitulo.setFont(UIStyle.FONT_SUBTITLE);
        jLblTitulo.setForeground(UIStyle.TEXT_PRIMARY);
        
        checkBoxAdmin.setFont(UIStyle.FONT_LABEL);
        checkBoxAdmin.setForeground(UIStyle.TEXT_PRIMARY);
        
        jPanelCard.setBackground(UIStyle.CARD_COLOR);
        jPanelCard.setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.LineBorder(UIStyle.BORDER_COLOR, 1, true),
            new javax.swing.border.EmptyBorder(30, 30, 30, 30)
        ));
    }
    
    public void preencheForm() {
        nomeField.setText(user.getNome());
        emailField.setText(user.getEmail());
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
        setResizable(false);

        jPanelCard = new javax.swing.JPanel();
        jLblTitulo = new javax.swing.JLabel();
        jLblLogo = new javax.swing.JLabel();
        jBtnVoltar1 = new javax.swing.JButton();
        jBtnAdicionar2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        senhaField = new javax.swing.JPasswordField();
        checkBoxAdmin = new javax.swing.JCheckBox();

        jPanelCard.setBackground(new java.awt.Color(255, 255, 255));

        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("Cadastro de Usuário");
        jLblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jBtnVoltar1.setText("Cancelar");
        jBtnVoltar1.setPreferredSize(new java.awt.Dimension(140, 45));
        jBtnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltar1ActionPerformed(evt);
            }
        });

        jBtnAdicionar2.setText("Salvar");
        jBtnAdicionar2.setPreferredSize(new java.awt.Dimension(140, 45));
        jBtnAdicionar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionar2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("Email:");

        jLabel3.setText("Senha:");

        nomeField.setPreferredSize(new java.awt.Dimension(300, 40));

        emailField.setPreferredSize(new java.awt.Dimension(300, 40));

        senhaField.setPreferredSize(new java.awt.Dimension(300, 40));

        checkBoxAdmin.setText("É administrador?");

        javax.swing.GroupLayout jPanelCardLayout = new javax.swing.GroupLayout(jPanelCard);
        jPanelCard.setLayout(jPanelCardLayout);
        jPanelCardLayout.setHorizontalGroup(
            jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCardLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelCardLayout.createSequentialGroup()
                        .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(senhaField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelCardLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(checkBoxAdmin))
                    .addGroup(jPanelCardLayout.createSequentialGroup()
                        .addComponent(jBtnVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jBtnAdicionar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        jPanelCardLayout.setVerticalGroup(
            jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCardLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLblTitulo)
                .addGap(30, 30, 30)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(checkBoxAdmin)
                .addGap(30, 30, 30)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAdicionar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        setMinimumSize(new java.awt.Dimension(650, 550));
        setPreferredSize(new java.awt.Dimension(650, 550));
        setSize(new java.awt.Dimension(650, 550));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltar1ActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnVoltar1ActionPerformed

    private void jBtnAdicionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionar2ActionPerformed
        try {
            Usuario userEnviado;
            boolean resposta;
            String senha = new String(senhaField.getPassword());
        
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[ ] = md.digest(senha.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(byte b: messageDigest){
            sb.append(String.format("%02x",0xFF & b));
            }
            String senhaMax = sb.toString();

            if(user != null) {
                userEnviado = new Usuario(user.getId(),
                        nomeField.getText(),
                        emailField.getText(),
                        senhaMax,
                        checkBoxAdmin.isSelected());
                resposta = Principal.ccont.atualizarUsuario(userEnviado);
            } else {
                userEnviado = new Usuario(nomeField.getText(),
                        emailField.getText(),
                        senhaMax,
                        checkBoxAdmin.isSelected());
                resposta = Principal.ccont.inserirUsuario(userEnviado);
            }

            if(resposta) {
                JOptionPane.showMessageDialog(this, "Usuário salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                telaLista.atualizaTabela();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao criptografar senha: " + e.getMessage());
        }
    }//GEN-LAST:event_jBtnAdicionar2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxAdmin;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jBtnAdicionar2;
    private javax.swing.JButton jBtnVoltar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLblLogo;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanelCard;
    private javax.swing.JTextField nomeField;
    private javax.swing.JPasswordField senhaField;
    // End of variables declaration//GEN-END:variables
}
