package com.example.controller;

import com.example.model.FornecedorAlfa;
import com.example.service.FornecedorAlfaService;
import com.example.service.dto.FornecedorAlfaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedorAlfa")
public class FornecedorAlfaController {

    @Autowired
    private FornecedorAlfaService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorAlfa>> listarProdutos() {
        return ResponseEntity.status(HttpStatus.FOUND).body(fornecedorService.listarEstoqueAlfa());
    }

    @GetMapping("/buscar")
    public ResponseEntity<FornecedorAlfaDTO> buscarPorNome(@RequestParam(name = "nomeProduto", required = false) String nome) {
        FornecedorAlfa produtoEncontrado = fornecedorService.buscarPorNomeFornecedorAlfa(nome);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FornecedorAlfaDTO(produtoEncontrado.getNomeProduto(), produtoEncontrado.getPreco(), produtoEncontrado.getCategoria(), produtoEncontrado.getQtdUnidades()));
    }

    @GetMapping("/retirar")
    public ResponseEntity<FornecedorAlfaDTO> retirarPorNome(@RequestParam(name = "nomeProduto", required = true) String nome, @RequestParam(name = "qtdUnidades", required = true) long qtd) {
        FornecedorAlfaDTO produtoRetirado = fornecedorService.retirarProdutoFornecedorAlfa(nome, qtd);
        return ResponseEntity.status(HttpStatus.FOUND).body(produtoRetirado);
    }

    @PostMapping
    public ResponseEntity<FornecedorAlfa> adicionarProduto(@RequestBody @Validated FornecedorAlfa produto) {
        FornecedorAlfa novoProduto = fornecedorService.adicionarItemFornecedorAlfa(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @DeleteMapping("/{idProduto}")
    public void removerProduto(@PathVariable long idProduto) {
        fornecedorService.removerProdutoFornecedorAlfa(idProduto);
    }
}
