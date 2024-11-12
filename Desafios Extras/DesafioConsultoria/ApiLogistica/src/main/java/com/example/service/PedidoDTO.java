package com.example.service;

import com.example.service.records.DadosProduto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {
    private long id;
    private String cliente;
    private List<DadosProduto> produtos = new ArrayList<>();
    private Double precoTotal;

    public PedidoDTO(long id, String cliente, List<DadosProduto> produtos) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
        this.precoTotal = produtos.stream().mapToDouble(p -> p.preco() * p.qtdUnidades()).sum();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<DadosProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<DadosProduto> produtos) {
        this.produtos = produtos;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
