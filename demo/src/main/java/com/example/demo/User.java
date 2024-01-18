package com.example.demo;

public class User {
    private String nome;
    private String localita;
    private String saluto;


    public User(String nome, String localita, String saluto) {
        this.nome = nome;
        this.localita = localita;
        this.saluto = saluto;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalita() {
        return localita;
    }

    public void setLocalita(String localita) {
        this.localita = localita;
    }

    public String getSaluto() {
        return saluto;
    }

    public void setSaluto(String saluto) {
        this.saluto = saluto;
    }

}
