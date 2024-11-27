package com.example.ApiBeta.model;

public class SaldoRequest {
    private Long clienteId;

    public SaldoRequest(int clienteId, int i) {
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
