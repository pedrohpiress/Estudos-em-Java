package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fornecedor_alfa")
public class FornecedorAlfa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private Double preco;
    private String categoria;
    private Long qtdUnidades;

    public FornecedorAlfa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getQtdUnidades() {
        return qtdUnidades;
    }

    public void setQtdUnidades(Long qtdUnidades) {
        this.qtdUnidades = qtdUnidades;
    }
}
