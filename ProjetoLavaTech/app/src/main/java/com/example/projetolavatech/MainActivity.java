package com.example.projetolavatech;

import android.os.Bundle;

import androidx.core.splashscreen.SplashScreen;

import com.example.projetolavatech.controller.ConexaoController;

public class MainActivity  extends AppLavaTechActivity {

    public ConexaoController ccont;
    private boolean conectadoAoServidor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* instalando a splaschScreen */
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);

        /* definindo ate quando ela fica ativa*/
        splashScreen.setKeepOnScreenCondition(() -> !conectadoAoServidor);
        conectaServidor();

        setContentView(R.layout.activity_tela_login);
    }
}
