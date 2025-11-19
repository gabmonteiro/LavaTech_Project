package view;

import modelDominio.Cliente;
import modelDominio.Veiculo;
import com.toedter.calendar.JYearChooser;
import javax.swing.JOptionPane;
import view.utils.UIStyle;

public class TelaCriarVeiculo extends javax.swing.JFrame {
    
    private Cliente cliente;
    private Veiculo veiculo;
    private TelaListaVeiculos telaLista;
    private JYearChooser anoChooser;

    public TelaCriarVeiculo(Cliente cliente, Veiculo veiculo, TelaListaVeiculos telaLista) {
        initComponents();
        applyStyles();
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.telaLista = telaLista;
        setTitle("LavaTech - Editar Veículo");
        configurarAnoChooser();
        preencheForm();
    }
    
    public TelaCriarVeiculo(Cliente cliente, TelaListaVeiculos telaLista) {
        initComponents();
        applyStyles();
        this.cliente = cliente;
        this.telaLista = telaLista;
        setTitle("LavaTech - Novo Veículo");
        configurarAnoChooser();
    }
    
    private void applyStyles() {
        UIStyle.setFrameBackground(this);
        UIStyle.styleLabel(jLabel1);
        UIStyle.styleLabel(jLabel2);
        UIStyle.styleLabel(jLabel3);
        UIStyle.styleLabel(jLabel4);
        UIStyle.styleLabel(jLabel5);
        UIStyle.styleTextField(modeloField);
        UIStyle.styleTextField(marcaField);
        UIStyle.styleTextField(placaField);
        UIStyle.styleTextField(corField);
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
    
    private void configurarAnoChooser() {
        // Mudar o layout do painel para null para permitir posicionamento absoluto
        jPanel1.setLayout(null);
        
        // Criar e configurar o seletor de ano
        anoChooser = new JYearChooser();
        anoChooser.setBounds(0, 0, 300, 40);
        jPanel1.add(anoChooser);
        
        // Definir tamanho preferido do painel
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 40));
    }
    
   public void preencheForm() {
       if (veiculo != null) {
           modeloField.setText(veiculo.getModelo());
           marcaField.setText(veiculo.getMarca());
           placaField.setText(veiculo.getPlaca());
           corField.setText(veiculo.getCor());
           if (anoChooser != null) {
               anoChooser.setYear(veiculo.getAno());
           }
       }
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        modeloField = new javax.swing.JTextField();
        marcaField = new javax.swing.JTextField();
        jBtnVoltar = new javax.swing.JButton();
        jBtnAdicionar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        corField = new javax.swing.JTextField();
        placaField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanelCard = new javax.swing.JPanel();
        jLblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        modeloField = new javax.swing.JTextField();
        marcaField = new javax.swing.JTextField();
        jBtnVoltar = new javax.swing.JButton();
        jBtnAdicionar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        corField = new javax.swing.JTextField();
        placaField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        jPanelCard.setBackground(new java.awt.Color(255, 255, 255));

        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("Cadastro de Veículo");
        jLblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Modelo:");

        jLabel2.setText("Marca:");

        modeloField.setPreferredSize(new java.awt.Dimension(300, 40));

        marcaField.setPreferredSize(new java.awt.Dimension(300, 40));

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

        jLabel3.setText("Cor:");

        jLabel4.setText("Placa:");

        jLabel5.setText("Ano:");

        placaField.setPreferredSize(new java.awt.Dimension(300, 40));

        corField.setPreferredSize(new java.awt.Dimension(300, 40));

        jPanel1.setLayout(null);
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 40));

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
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modeloField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(marcaField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(placaField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(corField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(modeloField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(marcaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(placaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(corField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        // Validações
        if (placaField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A placa é obrigatória!");
            return;
        }
        if (marcaField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A marca é obrigatória!");
            return;
        }
        if (modeloField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O modelo é obrigatório!");
            return;
        }
        if (corField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A cor é obrigatória!");
            return;
        }
        if (anoChooser == null || anoChooser.getYear() <= 0) {
            JOptionPane.showMessageDialog(null, "Selecione um ano válido!");
            return;
        }
        
        Veiculo veiculoEnviado;
        boolean resposta;
        if(veiculo != null && cliente != null) {
            veiculoEnviado = new Veiculo(veiculo.getId(),
                    placaField.getText().trim(),
                    marcaField.getText().trim(),
                    modeloField.getText().trim(),
                    corField.getText().trim(),
                    anoChooser.getYear(),
                    cliente);
            resposta = Principal.ccont.atualizarVeiculo(veiculoEnviado);
        } else {
            veiculoEnviado = new Veiculo(placaField.getText().trim(),
                    marcaField.getText().trim(),
                    modeloField.getText().trim(),
                    corField.getText().trim(),
                    anoChooser.getYear(),
                    cliente);
            resposta = Principal.ccont.inserirVeiculo(veiculoEnviado);
        }
        if(resposta) {
            JOptionPane.showMessageDialog(this, "Veículo salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            telaLista.atualizaTabela();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar veículo!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnAdicionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField corField;
    private javax.swing.JButton jBtnAdicionar;
    private javax.swing.JButton jBtnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCard;
    private javax.swing.JTextField marcaField;
    private javax.swing.JTextField modeloField;
    private javax.swing.JTextField placaField;
    // End of variables declaration//GEN-END:variables
}
