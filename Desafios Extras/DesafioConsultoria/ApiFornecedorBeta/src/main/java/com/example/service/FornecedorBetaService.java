package com.example.service;

import com.example.model.FornecedorBeta;
import com.example.repository.FornecedorBetaRepository;
import com.example.service.dto.FornecedorBetaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class FornecedorBetaService {

    @Autowired
    private FornecedorBetaRepository fornecedorBetaRepository;

    public FornecedorBeta adicionarItemFornecedorBeta(FornecedorBeta produto) {
        fornecedorBetaRepository.save(produto);
        return produto;
    }

    public List<FornecedorBeta> listarEstoqueBeta() {
        return fornecedorBetaRepository.findAll();
    }

    public FornecedorBeta buscarPorIdFornecedorBeta(long idProduto) {
        return fornecedorBetaRepository.findById(idProduto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto de id " + idProduto + " não encontrado no fornecedor Beta."));
    }

    public FornecedorBeta buscarPorNomeFornecedorBeta(String nome) {
        return fornecedorBetaRepository.findByNomeProduto(nome)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto " + nome + " não encontrado no fornecedor Beta."));
    }

    public void removerProdutoFornecedorBeta(long idProduto) {
        FornecedorBeta produto = buscarPorIdFornecedorBeta(idProduto);
        fornecedorBetaRepository.delete(produto);
    }

    public FornecedorBetaDTO retirarProdutoFornecedorAlfa(String nome, Long qtd){
        FornecedorBeta produto = buscarPorNomeFornecedorBeta(nome);

        if(produto.getQtdUnidades() < qtd){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade em estoque do produto do fornecedor Alfa " + produto.getNomeProduto() + " menor do que Quantidade requerida.");
        }
        produto.setQtdUnidades(produto.getQtdUnidades() - qtd);
        fornecedorBetaRepository.save(produto);
        return new FornecedorBetaDTO(produto.getNomeProduto(), produto.getPreco(), produto.getCategoria(), produto.getQtdUnidades());
    }
}
