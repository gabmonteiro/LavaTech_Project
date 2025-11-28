package view;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelDominio.Agendamento;
import modelDominio.Cliente;
import modelDominio.Funcionario;
import modelDominio.Servico;
import modelDominio.Veiculo;
import view.utils.ComboBoxItem;
import view.utils.UIStyle;

public class TelaCriarAgendamento extends javax.swing.JFrame {
    
    private Agendamento agendamento;
    private TelaListaAgendamentos telaLista;
    private JDateChooser dateChooser;
    private javax.swing.JSpinner timeSpinner;
    
    public TelaCriarAgendamento(TelaListaAgendamentos telaLista) {
        initComponents();
        applyStyles();
        this.telaLista = telaLista;
        setTitle("LavaTech - Novo Agendamento");
        carregarComboBoxes();
        configurarDataHora();
    }
    
    public TelaCriarAgendamento(Agendamento agendamento, TelaListaAgendamentos telaLista) {
        initComponents();
        applyStyles();
        this.telaLista = telaLista;
        this.agendamento = agendamento;
        setTitle("LavaTech - Editar Agendamento");
        carregarComboBoxes();
        configurarDataHora();
        preencheForm();
    }
    
    private void applyStyles() {
        UIStyle.setFrameBackground(this);
        UIStyle.styleLabel(jLabel1);
        UIStyle.styleLabel(jLabel2);
        UIStyle.styleLabel(jLabel3);
        UIStyle.styleLabel(jLabel4);
        UIStyle.styleLabel(jLabel5);
        UIStyle.styleLabel(jLabel6);
        UIStyle.styleComboBox(comboCliente);
        UIStyle.styleComboBox(comboVeiculo);
        UIStyle.styleComboBox(comboFuncionario);
        UIStyle.styleComboBox(comboServico);
        UIStyle.styleComboBox(comboStatus);
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
    
    private void configurarDataHora() {
        // Configurar seletor de data
        dateChooser = new JDateChooser();
        dateChooser.setBounds(0, 0, 200, 40);
        jPanelDataHora.add(dateChooser);
        
        // Configurar seletor de hora
        javax.swing.SpinnerDateModel timeModel = new javax.swing.SpinnerDateModel();
        timeSpinner = new javax.swing.JSpinner(timeModel);
        javax.swing.JSpinner.DateEditor timeEditor = new javax.swing.JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setBounds(210, 0, 100, 40);
        jPanelDataHora.add(timeSpinner);
        
        jPanelDataHora.setPreferredSize(new java.awt.Dimension(310, 40));
    }
    
    private void carregarComboBoxes() {
        // Carregar Clientes
        ArrayList<Cliente> clientes = Principal.ccont.listarClientes();
        Vector<ComboBoxItem> clientesItems = new Vector<>();
        for (Cliente c : clientes) {
            clientesItems.add(new ComboBoxItem(c.getId(), c.getNome()));
        }
        comboCliente.setModel(new DefaultComboBoxModel<>(clientesItems));
        
        // Carregar Funcionários
        ArrayList<Funcionario> funcionarios = Principal.ccont.listarFuncionarios();
        Vector<ComboBoxItem> funcionariosItems = new Vector<>();
        for (Funcionario f : funcionarios) {
            funcionariosItems.add(new ComboBoxItem(f.getId(), f.getNome()));
        }
        comboFuncionario.setModel(new DefaultComboBoxModel<>(funcionariosItems));
        
        // Carregar Serviços
        ArrayList<Servico> servicos = Principal.ccont.listarServicos();
        Vector<ComboBoxItem> servicosItems = new Vector<>();
        for (Servico s : servicos) {
            servicosItems.add(new ComboBoxItem(s.getId(), s.getNome()));
        }
        comboServico.setModel(new DefaultComboBoxModel<>(servicosItems));
        
        // Carregar Veículos quando um cliente for selecionado
        comboCliente.addActionListener(e -> carregarVeiculos());
        
        // Carregar status
        String[] statusOptions = {"Agendado", "Em Andamento", "Cancelado", "Concluído"};
        comboStatus.setModel(new DefaultComboBoxModel<>(statusOptions));
    }
    
    private void carregarVeiculos() {
        int clienteId = ComboBoxItem.getSelectedKey(comboCliente);
        if (clienteId > 0) {
            ArrayList<Veiculo> veiculos = Principal.ccont.listarVeiculosPorCliente(clienteId);
            Vector<ComboBoxItem> veiculosItems = new Vector<>();
            for (Veiculo v : veiculos) {
                veiculosItems.add(new ComboBoxItem(v.getId(), v.getModelo() + " - " + v.getPlaca()));
            }
            comboVeiculo.setModel(new DefaultComboBoxModel<>(veiculosItems));
        } else {
            comboVeiculo.setModel(new DefaultComboBoxModel<>(new Vector<>()));
        }
    }
    
    public void preencheForm() {
        if (agendamento == null) return;
        
        // Preencher data/hora
        if (agendamento.getDataHora() != null) {
            Date date = Date.from(agendamento.getDataHora().atZone(ZoneId.systemDefault()).toInstant());
            dateChooser.setDate(date);
            timeSpinner.setValue(date);
        }
        
        // Preencher status
        comboStatus.setSelectedItem(agendamento.getStatus());
        
        // Selecionar cliente
        if (agendamento.getCliente() != null) {
            for (int i = 0; i < comboCliente.getItemCount(); i++) {
                ComboBoxItem item = (ComboBoxItem) comboCliente.getItemAt(i);
                if (item.getKey() == agendamento.getCliente().getId()) {
                    comboCliente.setSelectedIndex(i);
                    break;
                }
            }
            carregarVeiculos();
            
            // Selecionar veículo
            if (agendamento.getVeiculo() != null) {
                for (int i = 0; i < comboVeiculo.getItemCount(); i++) {
                    ComboBoxItem item = (ComboBoxItem) comboVeiculo.getItemAt(i);
                    if (item.getKey() == agendamento.getVeiculo().getId()) {
                        comboVeiculo.setSelectedIndex(i);
                        break;
                    }
                }
            }
        }
        
        // Selecionar funcionário
        if (agendamento.getFuncionario() != null) {
            for (int i = 0; i < comboFuncionario.getItemCount(); i++) {
                ComboBoxItem item = (ComboBoxItem) comboFuncionario.getItemAt(i);
                if (item.getKey() == agendamento.getFuncionario().getId()) {
                    comboFuncionario.setSelectedIndex(i);
                    break;
                }
            }
        }
        
        // Selecionar serviço
        if (agendamento.getServico() != null) {
            for (int i = 0; i < comboServico.getItemCount(); i++) {
                ComboBoxItem item = (ComboBoxItem) comboServico.getItemAt(i);
                if (item.getKey() == agendamento.getServico().getId()) {
                    comboServico.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox<>();
        comboVeiculo = new javax.swing.JComboBox<>();
        comboFuncionario = new javax.swing.JComboBox<>();
        comboServico = new javax.swing.JComboBox<>();
        comboStatus = new javax.swing.JComboBox<>();
        jPanelDataHora = new javax.swing.JPanel();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox<>();
        comboVeiculo = new javax.swing.JComboBox<>();
        comboFuncionario = new javax.swing.JComboBox<>();
        comboServico = new javax.swing.JComboBox<>();
        comboStatus = new javax.swing.JComboBox<>();
        jPanelDataHora = new javax.swing.JPanel();
        jBtnVoltar = new javax.swing.JButton();
        jBtnAdicionar = new javax.swing.JButton();

        jPanelCard.setBackground(new java.awt.Color(255, 255, 255));

        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("Cadastro de Agendamento");
        jLblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Data/Hora:");

        jLabel2.setText("Cliente:");

        jLabel3.setText("Veículo:");

        jLabel4.setText("Funcionário:");

        jLabel5.setText("Serviço:");

        jLabel6.setText("Status:");

        comboCliente.setPreferredSize(new java.awt.Dimension(300, 40));

        comboVeiculo.setPreferredSize(new java.awt.Dimension(300, 40));

        comboFuncionario.setPreferredSize(new java.awt.Dimension(300, 40));

        comboServico.setPreferredSize(new java.awt.Dimension(300, 40));

        comboStatus.setPreferredSize(new java.awt.Dimension(300, 40));

        jPanelDataHora.setLayout(null);
        jPanelDataHora.setPreferredSize(new java.awt.Dimension(300, 40));

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
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelDataHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboServico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDataHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        setMinimumSize(new java.awt.Dimension(750, 650));
        setPreferredSize(new java.awt.Dimension(750, 650));
        setSize(new java.awt.Dimension(750, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnVoltarActionPerformed

    private void jBtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarActionPerformed
        try {
            // Validações
            if (dateChooser.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Selecione uma data!", "Validação", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int clienteId = ComboBoxItem.getSelectedKey(comboCliente);
            int veiculoId = ComboBoxItem.getSelectedKey(comboVeiculo);
            int funcionarioId = ComboBoxItem.getSelectedKey(comboFuncionario);
            int servicoId = ComboBoxItem.getSelectedKey(comboServico);
            
            if (clienteId <= 0) {
                JOptionPane.showMessageDialog(this, "Selecione um cliente!", "Validação", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (veiculoId <= 0) {
                JOptionPane.showMessageDialog(this, "Selecione um veículo!", "Validação", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (funcionarioId <= 0) {
                JOptionPane.showMessageDialog(this, "Selecione um funcionário!", "Validação", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (servicoId <= 0) {
                JOptionPane.showMessageDialog(this, "Selecione um serviço!", "Validação", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String status = (String) comboStatus.getSelectedItem();
            if (status == null || status.trim().isEmpty()) {
                status = "Agendado";
            }
            
            // Obter objetos completos
            Cliente cliente = Principal.ccont.buscarClientePorId(clienteId);
            Veiculo veiculo = Principal.ccont.buscarVeiculoPorId(veiculoId);
            Funcionario funcionario = Principal.ccont.buscarFuncionarioPorId(funcionarioId);
            Servico servico = Principal.ccont.buscarServicoPorId(servicoId);
            
            if (cliente == null || veiculo == null || funcionario == null || servico == null) {
                JOptionPane.showMessageDialog(this, "Erro ao buscar dados! Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Combinar data e hora
            Date date = dateChooser.getDate();
            Date time = (Date) timeSpinner.getValue();
            
            java.util.Calendar calDate = java.util.Calendar.getInstance();
            calDate.setTime(date);
            java.util.Calendar calTime = java.util.Calendar.getInstance();
            calTime.setTime(time);
            
            LocalDateTime dataHora = LocalDateTime.of(
                calDate.get(java.util.Calendar.YEAR),
                calDate.get(java.util.Calendar.MONTH) + 1,
                calDate.get(java.util.Calendar.DAY_OF_MONTH),
                calTime.get(java.util.Calendar.HOUR_OF_DAY),
                calTime.get(java.util.Calendar.MINUTE),
                0
            );
            
            Agendamento agendamentoEnviado;
            boolean resposta;
            
            if(agendamento != null) {
                agendamentoEnviado = new Agendamento(
                    agendamento.getId(),
                    dataHora,
                    status,
                    cliente,
                    veiculo,
                    funcionario,
                    servico
                );
                resposta = Principal.ccont.atualizarAgendamento(agendamentoEnviado);
            } else {
                agendamentoEnviado = new Agendamento(
                    dataHora,
                    status,
                    cliente,
                    veiculo,
                    funcionario,
                    servico
                );
                resposta = Principal.ccont.inserirAgendamento(agendamentoEnviado);
            }
            
            if(resposta) {
                JOptionPane.showMessageDialog(this, "Agendamento salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                telaLista.atualizaTabela();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar agendamento!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao processar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnAdicionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ComboBoxItem> comboCliente;
    private javax.swing.JComboBox<ComboBoxItem> comboFuncionario;
    private javax.swing.JComboBox<ComboBoxItem> comboServico;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JComboBox<ComboBoxItem> comboVeiculo;
    private javax.swing.JButton jBtnAdicionar;
    private javax.swing.JButton jBtnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanelCard;
    private javax.swing.JPanel jPanelDataHora;
    // End of variables declaration//GEN-END:variables
}

