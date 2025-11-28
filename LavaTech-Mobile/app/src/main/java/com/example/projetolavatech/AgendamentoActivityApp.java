package com.example.projetolavatech;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projetolavatech.controller.ConexaoController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

import modelDominio.Agendamento;
import modelDominio.Cliente;
import modelDominio.Funcionario;
import modelDominio.Servico;
import modelDominio.Veiculo;

public class AgendamentoActivityApp extends AppLavaTechActivity {

    // Componentes de UI
    EditText editTextData, editTextHora;
    Spinner spinnerCliente, spinnerVeiculo, spinnerFuncionario, spinnerServico, spinnerStatus;
    Button buttonConfirmar, buttonVoltarLista;

    // Dados carregados
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
    private ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    private ArrayList<Servico> listaServicos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_agendamentos);

        // Conectar componentes
        editTextData = findViewById(R.id.editTextData);
        editTextHora = findViewById(R.id.editTextHora);
        spinnerCliente = findViewById(R.id.spinnerCliente);
        spinnerVeiculo = findViewById(R.id.spinnerVeiculo);
        spinnerFuncionario = findViewById(R.id.spinnerFuncionario);
        spinnerServico = findViewById(R.id.spinnerServico);
        spinnerStatus = findViewById(R.id.spinnerStatus);
        buttonConfirmar = findViewById(R.id.buttonConfirmar);
        buttonVoltarLista = findViewById(R.id.buttonVoltarLista);

        // Configurar seletores de data/hora
        configurarSeletoresDataHora();

        // Configurar spinner de status
        String[] statusOptions = {"Agendado", "Em Andamento", "Cancelado", "Concluído"};
        ArrayAdapter<String> statusAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, statusOptions);
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(statusAdapter);

        // Configurar listener do spinner de cliente para carregar veículos
        spinnerCliente.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {
                if (position > 0) { // Ignorar item "Selecione..."
                    SpinnerItem item = (SpinnerItem) parent.getItemAtPosition(position);
                    carregarVeiculos(item.getId());
                } else {
                    listaVeiculos.clear();
                    atualizarSpinnerVeiculo();
                }
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {}
        });

        // Configurar botões
        buttonVoltarLista.setOnClickListener(v -> finish());
        buttonConfirmar.setOnClickListener(v -> salvarAgendamento());

        // Carregar dados do servidor
        carregarDadosDoServidor();
    }

    private void configurarSeletoresDataHora() {
        editTextData.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        String dataFormatada = String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear);
                        editTextData.setText(dataFormatada);
                    }, year, month, day);

            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
            datePickerDialog.show();
        });

        editTextHora.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    (view, hourOfDay, minuteOfHour) -> {
                        String horaFormatada = String.format("%02d:%02d", hourOfDay, minuteOfHour);
                        editTextHora.setText(horaFormatada);
                    }, hour, minute, true);
            timePickerDialog.show();
        });
    }

    private void carregarDadosDoServidor() {
        ConexaoController conexao = ConexaoController.getInstance();
        conexao.executar(() -> {
            Log.d("AgendamentoActivity", "Conexão estabelecida! Carregando dados...");
            new Thread(() -> {
                try {
                    // Carregar clientes
                    Log.d("AgendamentoActivity", "Carregando clientes...");
                    listaClientes = conexao.listarClientes().get(10, java.util.concurrent.TimeUnit.SECONDS);
                    runOnUiThread(() -> atualizarSpinnerCliente());

                    // Carregar funcionários
                    Log.d("AgendamentoActivity", "Carregando funcionários...");
                    listaFuncionarios = conexao.listarFuncionarios().get(10, java.util.concurrent.TimeUnit.SECONDS);
                    runOnUiThread(() -> atualizarSpinnerFuncionario());

                    // Carregar serviços
                    Log.d("AgendamentoActivity", "Carregando serviços...");
                    listaServicos = conexao.listarServicos().get(10, java.util.concurrent.TimeUnit.SECONDS);
                    runOnUiThread(() -> atualizarSpinnerServico());

                    Log.d("AgendamentoActivity", "Todos os dados carregados!");
                } catch (Exception e) {
                    Log.e("AgendamentoActivity", "Erro ao carregar dados: " + e.getMessage(), e);
                    runOnUiThread(() ->
                            Toast.makeText(AgendamentoActivityApp.this,
                                    "Erro ao carregar dados do servidor.", Toast.LENGTH_LONG).show()
                    );
                }
            }).start();
        }, () -> {
            Log.e("AgendamentoActivity", "Falha na conexão");
            runOnUiThread(() ->
                    Toast.makeText(AgendamentoActivityApp.this,
                            "Não foi possível conectar ao servidor.", Toast.LENGTH_SHORT).show()
            );
        });
    }

    private void atualizarSpinnerCliente() {
        ArrayList<SpinnerItem> items = new ArrayList<>();
        items.add(new SpinnerItem(0, "Selecione um cliente..."));
        for (Cliente c : listaClientes) {
            items.add(new SpinnerItem(c.getId(), c.getNome()));
        }
        ArrayAdapter<SpinnerItem> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCliente.setAdapter(adapter);
    }

    private void carregarVeiculos(int clienteId) {
        ConexaoController conexao = ConexaoController.getInstance();
        conexao.executar(() -> {
            new Thread(() -> {
                try {
                    Log.d("AgendamentoActivity", "Carregando veículos do cliente " + clienteId);
                    listaVeiculos = conexao.listarVeiculosPorCliente(clienteId).get(10, java.util.concurrent.TimeUnit.SECONDS);
                    runOnUiThread(() -> atualizarSpinnerVeiculo());
                } catch (Exception e) {
                    Log.e("AgendamentoActivity", "Erro ao carregar veículos: " + e.getMessage(), e);
                    runOnUiThread(() -> {
                        listaVeiculos.clear();
                        atualizarSpinnerVeiculo();
                    });
                }
            }).start();
        }, () -> {
            listaVeiculos.clear();
            atualizarSpinnerVeiculo();
        });
    }

    private void atualizarSpinnerVeiculo() {
        ArrayList<SpinnerItem> items = new ArrayList<>();
        items.add(new SpinnerItem(0, "Selecione um veículo..."));
        for (Veiculo v : listaVeiculos) {
            items.add(new SpinnerItem(v.getId(), v.getModelo() + " - " + v.getPlaca()));
        }
        ArrayAdapter<SpinnerItem> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVeiculo.setAdapter(adapter);
    }

    private void atualizarSpinnerFuncionario() {
        ArrayList<SpinnerItem> items = new ArrayList<>();
        items.add(new SpinnerItem(0, "Selecione um funcionário..."));
        for (Funcionario f : listaFuncionarios) {
            items.add(new SpinnerItem(f.getId(), f.getNome()));
        }
        ArrayAdapter<SpinnerItem> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFuncionario.setAdapter(adapter);
    }

    private void atualizarSpinnerServico() {
        ArrayList<SpinnerItem> items = new ArrayList<>();
        items.add(new SpinnerItem(0, "Selecione um serviço..."));
        for (Servico s : listaServicos) {
            items.add(new SpinnerItem(s.getId(), s.getNome()));
        }
        ArrayAdapter<SpinnerItem> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerServico.setAdapter(adapter);
    }

    private void salvarAgendamento() {
        // Validações
        String dataStr = editTextData.getText().toString().trim();
        String horaStr = editTextHora.getText().toString().trim();

        if (dataStr.isEmpty() || horaStr.isEmpty()) {
            Toast.makeText(this, "Selecione data e hora!", Toast.LENGTH_SHORT).show();
            return;
        }

        SpinnerItem clienteItem = (SpinnerItem) spinnerCliente.getSelectedItem();
        SpinnerItem veiculoItem = (SpinnerItem) spinnerVeiculo.getSelectedItem();
        SpinnerItem funcionarioItem = (SpinnerItem) spinnerFuncionario.getSelectedItem();
        SpinnerItem servicoItem = (SpinnerItem) spinnerServico.getSelectedItem();

        if (clienteItem == null || clienteItem.getId() == 0) {
            Toast.makeText(this, "Selecione um cliente!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (veiculoItem == null || veiculoItem.getId() == 0) {
            Toast.makeText(this, "Selecione um veículo!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (funcionarioItem == null || funcionarioItem.getId() == 0) {
            Toast.makeText(this, "Selecione um funcionário!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (servicoItem == null || servicoItem.getId() == 0) {
            Toast.makeText(this, "Selecione um serviço!", Toast.LENGTH_SHORT).show();
            return;
        }

        String statusStr = (String) spinnerStatus.getSelectedItem();
        if (statusStr == null) statusStr = "Agendado";
        final String status = statusStr;

        try {
            // Parse data e hora
            String[] d = dataStr.split("/");
            String[] h = horaStr.split(":");
            LocalDate data = LocalDate.of(
                    Integer.parseInt(d[2]),
                    Integer.parseInt(d[1]),
                    Integer.parseInt(d[0])
            );
            LocalTime hora = LocalTime.of(
                    Integer.parseInt(h[0]),
                    Integer.parseInt(h[1])
            );
            final LocalDateTime dataHora = LocalDateTime.of(data, hora);

            // IDs finais para usar no lambda
            final int clienteId = clienteItem.getId();
            final int veiculoId = veiculoItem.getId();
            final int funcionarioId = funcionarioItem.getId();
            final int servicoId = servicoItem.getId();

            // Buscar objetos completos do servidor
            ConexaoController conexao = ConexaoController.getInstance();
            conexao.executar(() -> {
                new Thread(() -> {
                    try {
                        Log.d("AgendamentoActivity", "Buscando objetos completos...");
                        Cliente cliente = conexao.buscarClientePorId(clienteId).get(10, java.util.concurrent.TimeUnit.SECONDS);
                        Veiculo veiculo = conexao.buscarVeiculoPorId(veiculoId).get(10, java.util.concurrent.TimeUnit.SECONDS);
                        Funcionario funcionario = conexao.buscarFuncionarioPorId(funcionarioId).get(10, java.util.concurrent.TimeUnit.SECONDS);
                        Servico servico = conexao.buscarServicoPorId(servicoId).get(10, java.util.concurrent.TimeUnit.SECONDS);

                        if (cliente == null || veiculo == null || funcionario == null || servico == null) {
                            runOnUiThread(() ->
                                    Toast.makeText(AgendamentoActivityApp.this,
                                            "Erro ao buscar dados! Tente novamente.", Toast.LENGTH_LONG).show()
                            );
                            return;
                        }

                        Agendamento agendamento = new Agendamento(
                                dataHora,
                                status,
                                cliente,
                                veiculo,
                                funcionario,
                                servico
                        );

                        Log.d("AgendamentoActivity", "Inserindo agendamento...");
                        boolean sucesso = conexao.inserirAgendamento(agendamento).get(10, java.util.concurrent.TimeUnit.SECONDS);

                        runOnUiThread(() -> {
                            if (sucesso) {
                                Toast.makeText(AgendamentoActivityApp.this,
                                        "Agendamento salvo com sucesso!", Toast.LENGTH_LONG).show();
                                // Retornar resultado para atualizar a lista
                                setResult(RESULT_OK);
                                finish();
                            } else {
                                Toast.makeText(AgendamentoActivityApp.this,
                                        "Erro ao salvar agendamento!", Toast.LENGTH_LONG).show();
                            }
                        });
                    } catch (Exception e) {
                        Log.e("AgendamentoActivity", "Erro ao salvar: " + e.getMessage(), e);
                        runOnUiThread(() ->
                                Toast.makeText(AgendamentoActivityApp.this,
                                        "Erro ao salvar agendamento: " + e.getMessage(), Toast.LENGTH_LONG).show()
                        );
                    }
                }).start();
            }, () -> {
                runOnUiThread(() ->
                        Toast.makeText(AgendamentoActivityApp.this,
                                "Não foi possível conectar ao servidor.", Toast.LENGTH_SHORT).show()
                );
            });
        } catch (Exception e) {
            Log.e("AgendamentoActivity", "Erro ao processar: " + e.getMessage(), e);
            Toast.makeText(this, "Data ou hora em formato inválido.", Toast.LENGTH_SHORT).show();
        }
    }
}
