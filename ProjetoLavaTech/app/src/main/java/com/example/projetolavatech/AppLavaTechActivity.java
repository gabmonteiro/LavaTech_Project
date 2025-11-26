package com.example.projetolavatech;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetolavatech.controller.ConexaoController;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class AppLavaTechActivity extends AppCompatActivity {

    public ConexaoController ccont;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ccont = ConexaoController.getInstance(); // recupera a conexao
    }

    // param <T> o tipo de dado que a operacao de rede retorna
    public <T> void executarOperacao(Callable<Future<T>> operacaoDeRede, Consumer<T> noSucesso) {
        ccont.executar(
                () -> new Thread(() -> { // carrega uma thread
                    try {
                        final T resultado = operacaoDeRede.call().get(); // tenta executar a operacao
                        runOnUiThread(() -> noSucesso.accept(resultado)); // caso consiga executa
                    } catch (Exception e) { // se der erro mostra o aviso
                       runOnUiThread(() -> Toast.makeText(this,"Erro na operação.", Toast.LENGTH_SHORT).show());
                    }
                }).start(), //executa a thread carregada
                // mostra na tela caso nem estiver conectado
                () -> runOnUiThread(() -> Toast.makeText(this,"Falha na conexão.",Toast.LENGTH_LONG).show()
        )
                );

    }
}