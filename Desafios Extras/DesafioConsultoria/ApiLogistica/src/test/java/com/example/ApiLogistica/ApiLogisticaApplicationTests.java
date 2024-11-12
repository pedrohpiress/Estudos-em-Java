package com.example.ApiLogistica;

import com.example.model.ItemPedido;
import com.example.model.Pedido;
import com.example.repository.PedidoRepository;
import com.example.service.PedidoDTO;
import com.example.service.PedidoService;
import com.example.service.records.DadosProduto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ApiLogisticaApplicationTests {

	@Autowired
	private PedidoService pedidoService;

	@MockBean
	private PedidoRepository pedidoRepository;

	@Test
	void testCriarPedidoBeta() {
		Pedido pedido = new Pedido();
		pedido.setCliente("Cliente Teste");

		pedidoService.criarPedidoBeta(pedido)

		verify(pedidoRepository).save(Mockito.any(Pedido.class));
	}

	@Test
	void testCriarPedidoBeta_ComNomeVazio() {
		// Preparando o pedido com nome vazio
		Pedido pedido = new Pedido();
		pedido.setCliente("");
		pedido.setProdutos(new ArrayList<>());

		PedidoService pedidoService = new PedidoService(); // Não estamos usando o repositório aqui

		// Chamando o método
		PedidoDTO resultado = pedidoService.criarPedidoBeta(pedido);

		// Testando se o nome vazio é tratado corretamente
		assertEquals("", resultado.getCliente(), "O nome do cliente deve ser vazio");
	}

	@Test
	void testCriarPedidoBeta_ComPrecoZero() {
		// Criando pedido com um produto com preço 0
		Pedido pedido = new Pedido();
		pedido.setCliente("Cliente Teste");

		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setNomeProduto("Produto Teste");
		itemPedido.setQtdUnidades(0);  // Quantidade zero

		List<ItemPedido> itensPedido = new ArrayList<>();
		itensPedido.add(itemPedido);
		pedido.setProdutos(itensPedido);

		PedidoService pedidoService = new PedidoService(); // Sem repositório, simplificado

		// Simulando o retorno da API de estoque
		DadosProduto dadosProdutoMock = new DadosProduto("Produto Teste", 10.0, "Categoria", 0L);

		// Chamando o método
		PedidoDTO resultado = pedidoService.criarPedidoBeta(pedido);

		// Verificando se o preço total é zero, pois não há unidades
		assertEquals(0.0, resultado.getPrecoTotal(), 0.01, "O preço total deve ser zero");
	}
}

