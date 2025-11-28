package com.example.projetolavatech;

public class SpinnerItem {
    private int id;
    private String nome;

    public SpinnerItem(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}

