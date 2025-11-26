package com.example.projetolavatech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivityApp extends AppLavaTechActivity {

    // 1. Declarar os componentes
    Button buttonLogin;
    EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        // 2. Conectar os componentes do Java com o XML
        buttonLogin = findViewById(R.id.buttonLogin);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        // 3. Criar a ação do clique do botão
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação: Abrir a tela de Agendamento
                Intent intent = new Intent(LoginActivityApp.this, ListaAgendamentosActivityApp.class);
                startActivity(intent);
            }
        });
    }
}