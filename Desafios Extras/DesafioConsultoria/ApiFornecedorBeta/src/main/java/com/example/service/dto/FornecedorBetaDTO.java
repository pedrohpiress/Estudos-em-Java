package com.example.service.dto;

public class FornecedorBetaDTO {
    private String nomeProduto;
    private Double preco;
    private String categoria;
    private Long qtdUnidades;

    public FornecedorBetaDTO() {
    }

    public FornecedorBetaDTO(String nomeProduto, Double preco, String categoria, Long qtdUnidades) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.categoria = categoria;
        this.qtdUnidades = qtdUnidades;
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
