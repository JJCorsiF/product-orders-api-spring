package com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.aplicacao.servicos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.aplicacao.excecoes.ExcecaoPedidoJaExiste;
import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.aplicacao.repositorios.RepositorioDePedidos;
import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServicoDePedidos {
	
	@Autowired
	@Qualifier("pedidos.jpa")
	private final RepositorioDePedidos repositorioDePedidos;
	
	public ServicoDePedidos(RepositorioDePedidos repositorioDePedidos) {
		this.repositorioDePedidos = repositorioDePedidos;
	}
	
	public List<Pedido> listarTodosOsPedidos() {
		return this.repositorioDePedidos.findAll();
	}
	
	public Optional<Pedido> listarPedidoPorNumeroDeControle(Integer numeroDeControle) {
		return this.repositorioDePedidos.findById(numeroDeControle);
	}
	
	public List<Pedido> listarPedidosPorDataDeCadastro(Date dataDeCadastro) {
		return this.repositorioDePedidos.findByDataDeCadastro(dataDeCadastro);
	}
	
	public List<Pedido> listarPedidosPorCodigoDoCliente(String codigoDoCliente) {
		return this.repositorioDePedidos.findAllByCodigoDoCliente(codigoDoCliente);
	}
	
	public Optional<Pedido> adicionarPedido(Pedido pedido) {
		Optional<Pedido> pedidoExistente = this.listarPedidoPorNumeroDeControle(pedido.getNumeroDeControle());
		
		if (pedidoExistente.isPresent()) {
			throw new ExcecaoPedidoJaExiste();
		}
		
		return Optional.ofNullable(this.repositorioDePedidos.save(pedido));
	}
}
