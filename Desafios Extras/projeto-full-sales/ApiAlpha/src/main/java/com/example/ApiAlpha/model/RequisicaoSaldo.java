package com.example.ApiAlpha.model;

public class RequisicaoSaldo {
    private Long clienteId;

    public RequisicaoSaldo() {}

    public RequisicaoSaldo(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}


