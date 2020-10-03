package com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.aplicacao.servicos;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Random;

import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.aplicacao.repositorios.RepositorioDePedidos;
import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido.Pedido;
import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido.Preco;
import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido.Produto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ServicoDePedidosTests {
	
	private RepositorioDePedidos repositorioDePedidos = Mockito.mock(RepositorioDePedidos.class);
	
	private ServicoDePedidos servicoDePedidos;
	
	@BeforeEach
	void init() {
		this.servicoDePedidos = new ServicoDePedidos(this.repositorioDePedidos);
	}
	
	@Test
	public void pedidoECadastradoCorretamente() {
		Integer numeroDeControle = (new Random()).nextInt();
		String nomeDoProduto = "Um produto interessante";
		Preco preco = new Preco(500.0);
		Produto produto = new Produto(nomeDoProduto, preco);
		String codigoDoCliente = "cliente123";
		Pedido pedido = new Pedido(numeroDeControle, produto, codigoDoCliente);
		
		when(repositorioDePedidos.save(any(Pedido.class))).thenAnswer(p -> {
			return p.getArgument(0);
		});
		Pedido pedidoCadastrado = this.servicoDePedidos.adicionarPedido(pedido).orElse(null);
		assertNotNull(pedidoCadastrado);
	}
}
