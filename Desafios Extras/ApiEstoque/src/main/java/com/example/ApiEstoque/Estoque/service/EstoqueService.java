package com.example.ApiEstoque.Estoque.service;

import com.example.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;


    public boolean verificarDisponibilidade(Long id, Integer quantidade) {
        return estoqueRepository.findById(id)
                .map(produto -> produto.getQuantidade() >= quantidade)
                .orElse(false);
    }
}
