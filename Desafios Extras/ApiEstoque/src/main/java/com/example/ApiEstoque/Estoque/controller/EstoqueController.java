package com.example.ApiEstoque.Estoque.controller;

import com.example.ApiMercado.Estoque.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("/produto/{id}")
    public ResponseEntity<Boolean> verificarEstoque(@PathVariable Long id, @RequestParam Integer quantidade){
        boolean disponivel = estoqueService.verificarDisponibilidade(id,quantidade);
        return ResponseEntity.ok(disponivel);
    }

}
