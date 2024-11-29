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

		pedidoService.criarPedidoBeta(pedido);

		verify(pedidoRepository).save(Mockito.any(Pedido.class));
	}

	@Test
	void testCriarPedidoBeta_ComNomeVazio() {
		Pedido pedido = new Pedido();
		pedido.setCliente("");
		pedido.setProdutos(new ArrayList<>());

		PedidoService pedidoService = new PedidoService();

		PedidoDTO resultado = pedidoService.criarPedidoBeta(pedido);

		assertEquals("", resultado.getCliente(), "O nome do cliente deve ser vazio");
	}

	@Test
	void testCriarPedidoBeta_ComPrecoZero() {
		Pedido pedido = new Pedido();
		pedido.setCliente("Cliente Teste");

		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setNomeProduto("Produto Teste");
		itemPedido.setQtdUnidades(0);

		List<ItemPedido> itensPedido = new ArrayList<>();
		itensPedido.add(itemPedido);
		pedido.setProdutos(itensPedido);

		PedidoService pedidoService = new PedidoService();

		DadosProduto dadosProdutoMock = new DadosProduto("Produto Teste", 10.0, "Categoria", 0L);

		PedidoDTO resultado = pedidoService.criarPedidoBeta(pedido);
		assertEquals(0.0, resultado.getPrecoTotal(), 0.01, "O preço total deve ser zero");
	}
}

