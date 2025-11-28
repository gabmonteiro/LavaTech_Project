package com.example.projetolavatech;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.example.projetolavatech.controller.ConexaoController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelDominio.Agendamento;

public class ListaAgendamentosActivityApp extends AppLavaTechActivity {

    ListView listViewAgendamentos;
    FloatingActionButton fabNovoAgendamento;
    Button buttonSair;
    
    private ActivityResultLauncher<Intent> agendamentoLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ListaAgendamentos", "onCreate chamado!");
        setContentView(R.layout.activity_lista_agendamentos);
        Log.d("ListaAgendamentos", "Layout carregado!");

        // Configurar ActivityResultLauncher para atualizar lista após criar agendamento
        agendamentoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Log.d("ListaAgendamentos", "Agendamento criado, atualizando lista...");
                        carregarAgendamentosDoServidor();
                    }
                }
        );

        listViewAgendamentos = findViewById(R.id.listViewAgendamentos);
        fabNovoAgendamento = findViewById(R.id.fabNovoAgendamento);
        buttonSair = findViewById(R.id.buttonSairLista);

        if (listViewAgendamentos == null) {
            Log.e("ListaAgendamentos", "listViewAgendamentos é null!");
        }
        if (fabNovoAgendamento == null) {
            Log.e("ListaAgendamentos", "fabNovoAgendamento é null!");
        }
        if (buttonSair == null) {
            Log.e("ListaAgendamentos", "buttonSair é null!");
        }

        fabNovoAgendamento.setOnClickListener(v -> {
            Log.d("ListaAgendamentos", "FAB clicado! Abrindo AgendamentoActivityApp...");
            Intent intent = new Intent(ListaAgendamentosActivityApp.this, AgendamentoActivityApp.class);
            agendamentoLauncher.launch(intent);
        });

        configurarBotaoSair();
        carregarAgendamentosDoServidor();
        Log.d("ListaAgendamentos", "onCreate concluído!");
    }

    private void carregarAgendamentosDoServidor() {
        Log.d("ListaAgendamentos", "Carregando agendamentos do servidor...");
        ConexaoController conexao = ConexaoController.getInstance();
        conexao.executar(() -> {
            Log.d("ListaAgendamentos", "Conexão estabelecida! Iniciando listagem de agendamentos...");
            // Executar em thread separada para evitar deadlock
            new Thread(() -> {
                try {
                    Log.d("ListaAgendamentos", "Chamando listarAgendamentos() em thread separada...");
                    java.util.concurrent.Future<ArrayList<Agendamento>> futureLista = conexao.listarAgendamentos();
                    Log.d("ListaAgendamentos", "Future criado, aguardando resposta (com timeout de 10s)...");
                    
                    ArrayList<Agendamento> lista = null;
                    try {
                        lista = futureLista.get(10, java.util.concurrent.TimeUnit.SECONDS);
                        Log.d("ListaAgendamentos", "Lista recebida: " + (lista != null ? lista.size() + " agendamentos" : "null"));
                    } catch (java.util.concurrent.TimeoutException e) {
                        Log.e("ListaAgendamentos", "Timeout ao aguardar resposta!");
                        lista = new ArrayList<>();
                    }
                    
                    final ArrayList<Agendamento> listaFinal = lista != null ? lista : new ArrayList<>();
                    
                    runOnUiThread(() -> {
                        Log.d("ListaAgendamentos", "Atualizando ListView com " + listaFinal.size() + " agendamentos");
                        AgendamentoAdapter adapter = new AgendamentoAdapter(
                                ListaAgendamentosActivityApp.this,
                                listaFinal
                        );
                        adapter.setOnStatusChangeListener((agendamento, novoStatus) -> {
                            alterarStatusAgendamento(agendamento, novoStatus);
                        });
                        listViewAgendamentos.setAdapter(adapter);
                        Log.d("ListaAgendamentos", "ListView atualizada com adapter customizado!");
                    });

                } catch (Exception e) {
                    Log.e("ListaAgendamentos", "Erro ao carregar agendamentos: " + e.getMessage(), e);
                    e.printStackTrace();
                    runOnUiThread(() ->
                            Toast.makeText(ListaAgendamentosActivityApp.this,
                                    "Erro ao carregar agendamentos: " + e.getMessage(), Toast.LENGTH_LONG).show()
                    );
                }
            }).start();
        }, () -> {
            Log.e("ListaAgendamentos", "Falha na conexão com o servidor");
            runOnUiThread(() ->
                    Toast.makeText(ListaAgendamentosActivityApp.this,
                            "Não foi possível conectar ao servidor.", Toast.LENGTH_SHORT).show()
            );
        });
    }

    private void configurarBotaoSair() {
        buttonSair.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivityApp.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }


    private void alterarStatusAgendamento(Agendamento agendamento, String statusAtual) {
        // Criar diálogo para selecionar novo status
        String[] statusOptions = {"Agendado", "Em Andamento", "Cancelado", "Concluído"};
        
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Alterar Status do Agendamento #" + agendamento.getId());
        builder.setItems(statusOptions, (dialog, which) -> {
            String novoStatus = statusOptions[which];
            if (novoStatus.equals(statusAtual)) {
                Toast.makeText(this, "O status já é " + novoStatus, Toast.LENGTH_SHORT).show();
                return;
            }
            
            // Confirmar alteração
            android.app.AlertDialog.Builder confirmBuilder = new android.app.AlertDialog.Builder(this);
            confirmBuilder.setTitle("Confirmar Alteração");
            confirmBuilder.setMessage("Deseja alterar o status de \"" + statusAtual + "\" para \"" + novoStatus + "\"?");
            confirmBuilder.setPositiveButton("Sim", (d, w) -> {
                atualizarStatusNoServidor(agendamento, novoStatus);
            });
            confirmBuilder.setNegativeButton("Cancelar", null);
            confirmBuilder.show();
        });
        builder.show();
    }

    private void atualizarStatusNoServidor(Agendamento agendamento, String novoStatus) {
        Log.d("ListaAgendamentos", "Atualizando status do agendamento #" + agendamento.getId() + " para " + novoStatus);
        
        ConexaoController conexao = ConexaoController.getInstance();
        conexao.executar(() -> {
            new Thread(() -> {
                try {
                    // Criar cópia do agendamento com novo status
                    Agendamento agendamentoAtualizado = new Agendamento(
                            agendamento.getId(),
                            agendamento.getDataHora(),
                            novoStatus,
                            agendamento.getCliente(),
                            agendamento.getVeiculo(),
                            agendamento.getFuncionario(),
                            agendamento.getServico()
                    );

                    Log.d("ListaAgendamentos", "Enviando atualização para o servidor...");
                    boolean sucesso = conexao.atualizarAgendamento(agendamentoAtualizado).get(10, java.util.concurrent.TimeUnit.SECONDS);

                    runOnUiThread(() -> {
                        if (sucesso) {
                            Toast.makeText(ListaAgendamentosActivityApp.this,
                                    "Status alterado com sucesso!", Toast.LENGTH_SHORT).show();
                            // Atualizar lista
                            carregarAgendamentosDoServidor();
                        } else {
                            Toast.makeText(ListaAgendamentosActivityApp.this,
                                    "Erro ao alterar status!", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    Log.e("ListaAgendamentos", "Erro ao atualizar status: " + e.getMessage(), e);
                    runOnUiThread(() ->
                            Toast.makeText(ListaAgendamentosActivityApp.this,
                                    "Erro ao alterar status: " + e.getMessage(), Toast.LENGTH_LONG).show()
                    );
                }
            }).start();
        }, () -> {
            runOnUiThread(() ->
                    Toast.makeText(ListaAgendamentosActivityApp.this,
                            "Não foi possível conectar ao servidor.", Toast.LENGTH_SHORT).show()
            );
        });
    }
}
