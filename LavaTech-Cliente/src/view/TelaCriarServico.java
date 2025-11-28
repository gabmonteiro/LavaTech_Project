package view;

import javax.swing.JOptionPane;
import modelDominio.Servico;
import view.utils.UIStyle;

public class TelaCriarServico extends javax.swing.JFrame {
    
    private Servico servico;
    private TelaListaServicos telaLista;

    public TelaCriarServico(TelaListaServicos telaLista) {
        initComponents();
        applyStyles();
        this.telaLista = telaLista;
        setTitle("LavaTech - Novo Serviço");
    }
    
    public TelaCriarServico(Servico servico, TelaListaServicos telaLista) {
        initComponents();
        applyStyles();
        this.telaLista = telaLista;
        this.servico = servico;
        setTitle("LavaTech - Editar Serviço");
        preencheForm();
    }
    
    private void applyStyles() {
        UIStyle.setFrameBackground(this);
        UIStyle.styleLabel(jLabel1);
        UIStyle.styleLabel(jLabel2);
        UIStyle.styleLabel(jLabel3);
        UIStyle.styleLabel(jLabel4);
        UIStyle.styleTextField(nomeField);
        UIStyle.styleTextField(descricaoField);
        UIStyle.styleTextField(precoField);
        UIStyle.styleTextField(duracaoField);
        UIStyle.stylePrimaryButton(jBtnAdicionar);
        UIStyle.styleSecondaryButton(jBtnVoltar);
        
        jLblTitulo.setFont(UIStyle.FONT_SUBTITLE);
        jLblTitulo.setForeground(UIStyle.TEXT_PRIMARY);
        
        jPanelCard.setBackground(UIStyle.CARD_COLOR);
        jPanelCard.setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.LineBorder(UIStyle.BORDER_COLOR, 1, true),
            new javax.swing.border.EmptyBorder(30, 30, 30, 30)
        ));
    }
    
    public void preencheForm() {
        nomeField.setText(servico.getNome());
        descricaoField.setText(servico.getDescricao());
        precoField.setText(String.valueOf(servico.getPreco()));
        duracaoField.setText(String.valueOf(servico.getDuracaoEstimadaMin()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        descricaoField = new javax.swing.JTextField();
        precoField = new javax.swing.JTextField();
        duracaoField = new javax.swing.JTextField();
        jBtnVoltar = new javax.swing.JButton();
        jBtnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanelCard = new javax.swing.JPanel();
        jLblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        descricaoField = new javax.swing.JTextField();
        precoField = new javax.swing.JTextField();
        duracaoField = new javax.swing.JTextField();
        jBtnVoltar = new javax.swing.JButton();
        jBtnAdicionar = new javax.swing.JButton();

        jPanelCard.setBackground(new java.awt.Color(255, 255, 255));

        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("Cadastro de Serviço");
        jLblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Nome:");

        jLabel2.setText("Descrição:");

        jLabel3.setText("Preço (R$):");

        jLabel4.setText("Duração (min):");

        nomeField.setPreferredSize(new java.awt.Dimension(300, 40));

        descricaoField.setPreferredSize(new java.awt.Dimension(300, 40));

        precoField.setPreferredSize(new java.awt.Dimension(300, 40));

        duracaoField.setPreferredSize(new java.awt.Dimension(300, 40));

        jBtnVoltar.setText("Cancelar");
        jBtnVoltar.setPreferredSize(new java.awt.Dimension(140, 45));
        jBtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarActionPerformed(evt);
            }
        });

        jBtnAdicionar.setText("Salvar");
        jBtnAdicionar.setPreferredSize(new java.awt.Dimension(140, 45));
        jBtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionarActionPerformed(evt);
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
                    .addGroup(jPanelCardLayout.createSequentialGroup()
                        .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descricaoField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(precoField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(duracaoField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelCardLayout.createSequentialGroup()
                        .addComponent(jBtnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jBtnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(descricaoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(precoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(duracaoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jBtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnVoltarActionPerformed

    private void jBtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarActionPerformed
        try {
            Servico servicoEnviado;
            boolean resposta;
            
            // Validações
            if (nomeField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O nome é obrigatório!");
                return;
            }
            
            float preco = 0;
            try {
                preco = Float.parseFloat(precoField.getText().trim());
                if (preco < 0) {
                    JOptionPane.showMessageDialog(null, "O preço deve ser maior ou igual a zero!");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Preço inválido! Use números decimais (ex: 50.00)");
                return;
            }
            
            int duracao = 0;
            try {
                duracao = Integer.parseInt(duracaoField.getText().trim());
                if (duracao <= 0) {
                    JOptionPane.showMessageDialog(null, "A duração deve ser maior que zero!");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Duração inválida! Use números inteiros.");
                return;
            }
            
            if(servico != null) {
                servicoEnviado = new Servico(
                    servico.getId(),
                    nomeField.getText().trim(),
                    descricaoField.getText().trim(),
                    preco,
                    duracao
                );
                resposta = Principal.ccont.atualizarServico(servicoEnviado);
            } else {
                servicoEnviado = new Servico(
                    nomeField.getText().trim(),
                    descricaoField.getText().trim(),
                    preco,
                    duracao
                );
                resposta = Principal.ccont.inserirServico(servicoEnviado);
            }
            
            if(resposta) {
                JOptionPane.showMessageDialog(this, "Serviço salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                telaLista.atualizaTabela();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar serviço!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao processar: " + e.getMessage());
        }
    }//GEN-LAST:event_jBtnAdicionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descricaoField;
    private javax.swing.JTextField duracaoField;
    private javax.swing.JButton jBtnAdicionar;
    private javax.swing.JButton jBtnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanelCard;
    private javax.swing.JTextField nomeField;
    private javax.swing.JTextField precoField;
    // End of variables declaration//GEN-END:variables
}

