package com.example.controller;

import com.example.model.FornecedorBeta;
import com.example.service.FornecedorBetaService;
import com.example.service.dto.FornecedorBetaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/fornecedorBeta")
public class FornecedorBetaController {
    @Autowired
    private FornecedorBetaService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorBeta>> listarProdutos(){
        return ResponseEntity.status(HttpStatus.FOUND).body(fornecedorService.listarEstoqueBeta());
    }

    @GetMapping("/buscar")
    public ResponseEntity<FornecedorBetaDTO> buscarPorNome(@RequestParam(name = "nomeProduto", required = false) String nome){
        FornecedorBeta produtoEncontrado = fornecedorService.buscarPorNomeFornecedorBeta(nome);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FornecedorBetaDTO(produtoEncontrado.getNomeProduto(), produtoEncontrado.getPreco(), produtoEncontrado.getCategoria(), produtoEncontrado.getQtdUnidades()));
    }

    @GetMapping("/retirar")
    public ResponseEntity<FornecedorBetaDTO> retirarPorNome(@RequestParam(name = "nomeProduto", required = true) String nome, @RequestParam(name = "qtdUnidades", required = true) long qtd){
        FornecedorBetaDTO produtoRetirado = fornecedorService.retirarProdutoFornecedorBeta(nome, qtd);
        return ResponseEntity.status(HttpStatus.FOUND).body(produtoRetirado);
    }

    @PostMapping
    public ResponseEntity<FornecedorBeta> adicionarProduto(@RequestBody @Validated FornecedorBeta produto){
        FornecedorBeta novoProduto = fornecedorService.adicionarItemFornecedorBeta(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @DeleteMapping("/{idProduto}")
    public void removerProduto(@PathVariable long idProduto){
        fornecedorService.removerProdutoFornecedorBeta(idProduto);
    }

}
