package com.example.service;

import com.example.model.FornecedorAlfa;
import com.example.repository.FornecedorAlfaRepository;
import com.example.service.dto.FornecedorAlfaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FornecedorAlfaService {
    @Autowired
    private FornecedorAlfaRepository fornecedorAlfaRepository;

    public FornecedorAlfa adicionarItemFornecedorAlfa(FornecedorAlfa produto){
        fornecedorAlfaRepository.save(produto);
        return produto;
    }


    public List<FornecedorAlfa> listarEstoqueAlfa(){
        return fornecedorAlfaRepository.findAll();
    }


    public FornecedorAlfa buscarPorIdFornecedorAlfa(long idProduto){
        return fornecedorAlfaRepository.findById(idProduto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto de id " + idProduto + " não encontrado no fornecedor Alfa."));
    }


    public FornecedorAlfa buscarPorNomeFornecedorAlfa(String nome){
        return fornecedorAlfaRepository.findByNomeProduto(nome).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto " + nome + " não encontrado no fornecedor Alfa."));
    }


    public void removerProdutoFornecedorAlfa(long idProduto){
        FornecedorAlfa produto = buscarPorIdFornecedorAlfa(idProduto);
        fornecedorAlfaRepository.delete(produto);
    }


    public FornecedorAlfaDTO retirarProdutoFornecedorAlfa(String nome, Long qtd){
        FornecedorAlfa produto = buscarPorNomeFornecedorAlfa(nome);

        if(produto.getQtdUnidades() < qtd){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade em estoque do produto do fornecedor Alfa " + produto.getNomeProduto() + " menor do que Quantidade requerida.");
        }
        produto.setQtdUnidades(produto.getQtdUnidades() - qtd);
        fornecedorAlfaRepository.save(produto);
        return new FornecedorAlfaDTO(produto.getNomeProduto(), produto.getPreco(), produto.getCategoria(), produto.getQtdUnidades());
    }

}
