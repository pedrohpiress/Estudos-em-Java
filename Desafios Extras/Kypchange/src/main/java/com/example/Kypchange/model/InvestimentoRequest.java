package com.example.Kypchange.model;

public class InvestimentoRequest {
    private Long idInvestimento;
    private String descricao;
    private Double valor;

    public InvestimentoRequest(Long idInvestimento, String descricao, Double valor) {
        this.idInvestimento = idInvestimento;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(Long idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
