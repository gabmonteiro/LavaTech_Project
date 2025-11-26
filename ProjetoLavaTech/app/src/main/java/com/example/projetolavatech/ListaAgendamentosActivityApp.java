package com.example.projetolavatech;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button; // NOVO: Importe o Button
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class ListaAgendamentosActivityApp extends AppLavaTechActivity {

    ListView listViewAgendamentos;
    FloatingActionButton fabNovoAgendamento;
    Button buttonSair; // 1. NOVO: Declarar o botão de sair

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agendamentos);

        listViewAgendamentos = findViewById(R.id.listViewAgendamentos);
        fabNovoAgendamento = findViewById(R.id.fabNovoAgendamento);
        buttonSair = findViewById(R.id.buttonSairLista); // 2. NOVO: Conectar o botão Sair
        // (Assumindo que o ID no XML é buttonSairLista)

        // Simulação de Dados para a Lista
        ArrayList<String> agendamentos = new ArrayList<>();
        agendamentos.add("15/11 às 10:00 - Cliente: Maria");
        agendamentos.add("15/11 às 14:30 - Cliente: João");
        agendamentos.add("16/11 às 09:00 - Cliente: Pedro");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, agendamentos);

        listViewAgendamentos.setAdapter(adapter);

        // Ação: Ao clicar no botão flutuante, ir para a tela de Cadastro
        fabNovoAgendamento.setOnClickListener(v -> {
            Intent intent = new Intent(ListaAgendamentosActivityApp.this, AgendamentoActivityApp.class);
            startActivity(intent);
        });

        // 3. NOVO: Chamar o método auxiliar de sair
        configurarBotaoSair();
    }

    private void configurarBotaoSair() {
        // Renomeei para configurarBotaoSair para maior clareza

        buttonSair.setOnClickListener(v -> {
            // Cria Intent para ir para MainActivity (Login) e limpar a pilha de Activities
            // Usando MainActivity.class (o nome padrão da tela de Login no seu projeto)
            Intent intent = new Intent(this, LoginActivityApp.class);

            // Flags: Limpa todas as atividades acima dela e inicia a MainActivity como nova tarefa
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}