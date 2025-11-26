package com.example.projetolavatech;

import android.app.Application;

import com.example.projetolavatech.controller.ConexaoController;

public class Principal extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // conexao é iniciada aqui
        ConexaoController.getInstance();
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
        // conexao é fechada aqui
        ConexaoController.getInstance().desconectar();
    }

}
