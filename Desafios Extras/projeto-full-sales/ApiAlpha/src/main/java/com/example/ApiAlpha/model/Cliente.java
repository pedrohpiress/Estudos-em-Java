package com.example.ApiAlpha.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    private String id;
    private String nome;
    private double saldo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

