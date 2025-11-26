package com.example.projetolavatech;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent; // Importa Intent para o botão Sair
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class AgendamentoActivityApp extends AppLavaTechActivity {

    // 1. Declarar os componentes
    EditText editTextData, editTextHora, editTextCliente;
    Spinner spinnerServico;
    Button buttonConfirmar, buttonVoltarLista, buttonSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_agendamentos);

        // ==========================================================
        // CORREÇÃO 1: Conectar TODOS os componentes do Java com o XML
        // (Isso é CRÍTICO para evitar NullPointerException)
        // ==========================================================
        editTextData = findViewById(R.id.editTextData);
        editTextHora = findViewById(R.id.editTextHora);
        editTextCliente = findViewById(R.id.editTextCliente);
        spinnerServico = findViewById(R.id.spinnerServico);

        buttonConfirmar = findViewById(R.id.buttonConfirmar);
        buttonVoltarLista = findViewById(R.id.buttonVoltarLista);
        buttonSair = findViewById(R.id.buttonSair);

        // 3. Configurar os cliques
        configurarSeletoresDataHora();
        configurarSpinnerServicos();
        configurarBotaoConfirmar();
        configurarBotoesSecundarios();
    } // Fim do onCreate

    // ==========================================================
    // CORREÇÃO 2: Métodos auxiliares movidos para DENTRO da classe
    // ==========================================================

    private void configurarSeletoresDataHora() {
        // Ação de clique para o campo DATA
        editTextData.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        String dataFormatada = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        editTextData.setText(dataFormatada);
                    }, year, month, day);

            // Impede a seleção de datas passadas
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
            datePickerDialog.show();
        });

        // Ação de clique para o campo HORA
        editTextHora.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    (view, hourOfDay, minuteOfHour) -> {
                        String horaFormatada = String.format("%02d:%02d", hourOfDay, minuteOfHour);
                        editTextHora.setText(horaFormatada);
                    }, hour, minute, true); // true = formato 24h
            timePickerDialog.show();
        });
    }

    private void configurarSpinnerServicos() {
        // 4. Criar a lista de serviços
        String[] servicos = {"Lavagem Simples", "Lavagem Completa", "Polimento", "Higienização"};

        // 5. Criar o Adaptador para o Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, servicos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 6. Ligar o Adaptador ao Spinner
        spinnerServico.setAdapter(adapter);
    }

    private void configurarBotoesSecundarios() {
        // 1. Botão "Voltar para a Lista"
        buttonVoltarLista.setOnClickListener(v -> {
            // Fecha a tela atual e retorna para ListaAgendamentosActivity.
            finish();
        });

        // 2. Botão "Sair do Aplicativo"
        buttonSair.setOnClickListener(v -> {
            // Cria Intent para ir para MainActivity (Login) e limpar a pilha de Activities
            Intent intent = new Intent(this, LoginActivityApp.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }

    private void configurarBotaoConfirmar() {
        // 7. Ação de clique para o botão CONFIRMAR
        buttonConfirmar.setOnClickListener(v -> {
            // Pegar os valores dos campos
            String data = editTextData.getText().toString();
            String hora = editTextHora.getText().toString();
            String cliente = editTextCliente.getText().toString();
            String servico = spinnerServico.getSelectedItem().toString();

            // Validar se os campos não estão vazios
            if (data.isEmpty() || hora.isEmpty() || cliente.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {
                // Mostrar mensagem de sucesso
                String mensagem = "Agendado para " + cliente + "\nServiço: " + servico + "\nEm: " + data + " às " + hora;
                Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();

                // Volta para a ListaAgendamentosActivity após confirmar
                finish();
            }
        });
    }
}