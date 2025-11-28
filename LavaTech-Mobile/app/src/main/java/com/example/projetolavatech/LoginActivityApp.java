package com.example.projetolavatech;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetolavatech.controller.ConexaoController;

import java.security.MessageDigest;

import modelDominio.Usuario;

public class LoginActivityApp extends AppLavaTechActivity {

    Button buttonLogin;
    EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        buttonLogin = findViewById(R.id.buttonLogin);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tentarLogin();
            }
        });
    }

    private void tentarLogin() {
        String email = editTextEmail.getText().toString().trim();
        String senha = editTextPassword.getText().toString();

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Informe e-mail e senha.", Toast.LENGTH_SHORT).show();
            return;
        }

        String senhaHash = sha256(senha);
        if (senhaHash == null) {
            Toast.makeText(this, "Erro ao criptografar senha.", Toast.LENGTH_SHORT).show();
            return;
        }

        ConexaoController conexao = ConexaoController.getInstance();
        // Primeiro garante conexão com o servidor
        conexao.executar(() -> {
            Log.d("LoginActivityApp", "Conexão estabelecida! Iniciando processo de login...");
            // Executar o login de forma assíncrona em uma nova thread para evitar deadlock
            new Thread(() -> {
                try {
                    Log.d("LoginActivityApp", "Chamando conexao.login() em thread separada...");
                    java.util.concurrent.Future<Usuario> futureUsuario = conexao.login(email, senhaHash);
                    Log.d("LoginActivityApp", "Future criado, aguardando resposta (com timeout de 10s)...");
                    
                    // Usar get() com timeout para evitar travamento infinito
                    Usuario usuario = null;
                    try {
                        usuario = futureUsuario.get(10, java.util.concurrent.TimeUnit.SECONDS);
                        Log.d("LoginActivityApp", "Resposta do login recebida. Usuario: " + (usuario != null ? usuario.getEmail() : "null"));
                    } catch (java.util.concurrent.TimeoutException e) {
                        Log.e("LoginActivityApp", "Timeout ao aguardar resposta do login!");
                        usuario = null;
                    }
                    
                    // Executar na UI thread - criar variável final para usar no lambda
                    final Usuario usuarioFinal = usuario;
                    runOnUiThread(() -> {
                        if (usuarioFinal != null) {
                            Log.d("LoginActivityApp", "Login OK! Redirecionando para ListaAgendamentosActivityApp...");
                            try {
                                Intent intent = new Intent(LoginActivityApp.this, ListaAgendamentosActivityApp.class);
                                startActivity(intent);
                                Log.d("LoginActivityApp", "Intent iniciado com sucesso!");
                                finish();
                            } catch (Exception e) {
                                Log.e("LoginActivityApp", "Erro ao iniciar Intent: " + e.getMessage(), e);
                                Toast.makeText(LoginActivityApp.this,
                                        "Erro ao abrir a tela de agendamentos.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.w("LoginActivityApp", "Login falhou: usuário ou senha inválidos");
                            Toast.makeText(LoginActivityApp.this,
                                    "Usuário ou senha inválidos.", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    Log.e("LoginActivityApp", "Erro no login: " + e.getMessage(), e);
                    e.printStackTrace();
                    runOnUiThread(() ->
                            Toast.makeText(LoginActivityApp.this,
                                    "Erro ao comunicar com o servidor: " + e.getMessage(), Toast.LENGTH_LONG).show()
                    );
                }
            }).start();
        }, () -> {
            Log.e("LoginActivityApp", "Falha na conexão com o servidor");
            runOnUiThread(() ->
                    Toast.makeText(LoginActivityApp.this,
                            "Não foi possível conectar ao servidor.", Toast.LENGTH_SHORT).show()
            );
        });
    }

    private String sha256(String valor) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(valor.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", 0xFF & b));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
