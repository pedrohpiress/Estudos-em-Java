package com.example.service;

import com.example.model.ItemPedido;
import com.example.model.Pedido;
import com.example.repository.ItemPedidoRepository;
import com.example.repository.PedidoRepository;
import com.example.service.records.DadosProduto;
import com.example.validacoes.PedidoNotFoundException;
import com.example.validacoes.ProdutoNaoEncontradoException;
import jakarta.el.MethodNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public DadosProduto retirarProdutoNoEstoqueAlfa(String nome, Integer qtd) {
        String urlFornecedorA = "http://localhost:8081/fornecedorAlfa/retirar?nomeProduto=" + nome + "&qtdUnidades=" + qtd;
        return restTemplate.getForObject(urlFornecedorA, DadosProduto.class);
    }

    public DadosProduto retirarProdutoNoEstoqueBeta(String nome, Integer qtd) {
        String urlFornecedorB = "http://localhost:8082/fornecedorBeta/retirar?nomeProduto=" + nome + "&qtdUnidades=" + qtd;
        return restTemplate.getForObject(urlFornecedorB, DadosProduto.class);
    }

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public PedidoDTO criarPedidoAlfa(Pedido pedido) {
        List<DadosProduto> dadosProdutos = new ArrayList<>();
        List<ItemPedido> novosItensPedido = new ArrayList<>();
        ItemPedido itemPedido = new ItemPedido();

        for (ItemPedido produtoAtual : pedido.getProdutos()) {
            DadosProduto produtoEstoque = retirarProdutoNoEstoqueAlfa(produtoAtual.getNomeProduto(), produtoAtual.getQtdUnidades());

            itemPedido.setNomeProduto(produtoAtual.getNomeProduto());
            itemPedido.setQtdUnidades(produtoAtual.getQtdUnidades());
            itemPedido.setPreco(produtoEstoque.preco() * produtoAtual.getQtdUnidades());
            itemPedido.setPedido(pedido);

            novosItensPedido.add(itemPedido);
            dadosProdutos.add(produtoEstoque);
        }

        if (itemPedido.getQtdUnidades() > pedido.getQtdItens()){
            throw new PedidoNotFoundException("A quantidade desejada é maior que tem no estoque deste fornecedor");
        }

        pedido.setProdutos(novosItensPedido);
        pedido.setQtdItens(itemPedido.getQtdUnidades());
        pedido.setPrecoTotal(dadosProdutos.stream()
                .mapToDouble(p -> p.preco() * itemPedido.getQtdUnidades())
                .sum());
        pedido.setFornecedor("Alfa");

        pedidoRepository.save(pedido);

        return new PedidoDTO(pedido.getId(), pedido.getCliente(), dadosProdutos);
    }

    public PedidoDTO criarPedidoBeta(Pedido pedido) {
        List<DadosProduto> dadosProdutos = new ArrayList<>();
        List<ItemPedido> novosItensPedido = new ArrayList<>();
        ItemPedido itemPedido = new ItemPedido();

        try {
            for (ItemPedido produtoAtual : pedido.getProdutos()) {
                DadosProduto produtoEstoque = retirarProdutoNoEstoqueBeta(produtoAtual.getNomeProduto(), produtoAtual.getQtdUnidades());

                itemPedido.setNomeProduto(produtoAtual.getNomeProduto());
                itemPedido.setQtdUnidades(produtoAtual.getQtdUnidades());
                itemPedido.setPreco(produtoEstoque.preco() * produtoAtual.getQtdUnidades());
                itemPedido.setPedido(pedido);

                novosItensPedido.add(itemPedido);
                dadosProdutos.add(produtoEstoque);
            }

            pedido.setProdutos(novosItensPedido);
            pedido.setQtdItens(itemPedido.getQtdUnidades());
            pedido.setPrecoTotal(dadosProdutos.stream()
                    .mapToDouble(p -> p.preco() * itemPedido.getQtdUnidades())
                    .sum());
            pedido.setFornecedor("Beta");

            Pedido pedidoComId = pedidoRepository.save(pedido);
            return new PedidoDTO(pedidoComId.getId(), pedido.getCliente(), dadosProdutos);
        } catch (ProdutoNaoEncontradoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado no estoque", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao criar pedido", e);
        }


    }


}
