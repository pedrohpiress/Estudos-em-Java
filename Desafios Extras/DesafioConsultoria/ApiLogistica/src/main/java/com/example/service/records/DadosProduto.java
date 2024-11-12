package com.example.service.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosProduto(
        String nomeProduto,
        Double preco,
        String categoria,
        Long qtdUnidades
) {
}
