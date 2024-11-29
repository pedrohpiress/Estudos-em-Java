package com.example.service.records;

public record DadosItensNota(
        String nomeItem,
        Integer qtdUnidades,
        Double preco,
        String fornecedor
) {
}
