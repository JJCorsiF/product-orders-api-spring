package com.jjcorsif.api_de_pedidos.ui.api.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.aplicacao.servicos.ServicoDePedidos;
import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido.Pedido;
import com.jjcorsif.api_de_pedidos.ui.api.rest.dtos.PedidoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/pedidos")
@CrossOrigin
public class ApiDePedidosRestController {
	
	private static final int NUMERO_MAXIMO_DE_PEDIDOS_POR_REQUISICAO = 10;

	@Autowired
	private final ServicoDePedidos servicoDePedidos;
	
	public ApiDePedidosRestController(ServicoDePedidos servicoDePedidos) {
		this.servicoDePedidos = servicoDePedidos;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Pedido> listarTodosOsPedidos() {
		return this.servicoDePedidos.listarTodosOsPedidos();
	}
	
	@GetMapping(path="{numeroDeControle}")
	@ResponseStatus(HttpStatus.OK)
	public Pedido listarPedidoPorNumeroDeControle(
		@PathVariable("numeroDeControle") Integer numeroDeControle
	) {
		return this.servicoDePedidos.listarPedidoPorNumeroDeControle(numeroDeControle).orElse(null);
	}
	
	@GetMapping(path="/data_cadastro/{dataDeCadastro}")
	@ResponseStatus(HttpStatus.OK)
	public List<Pedido> listarPedidosPorDataDeCadastro(
		@PathVariable("dataDeCadastro") String dataDeCadastro
	) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date data = dateFormat.parse(dataDeCadastro);
		return this.servicoDePedidos.listarPedidosPorDataDeCadastro(data);
	}
	
	@GetMapping(path="/cliente/{codigoDoCliente}")
	@ResponseStatus(HttpStatus.OK)
	public List<Pedido> listarPedidosPorCodigoDoCliente(
		@PathVariable("codigoDoCliente") String codigoDoCliente
	) {
		return this.servicoDePedidos.listarPedidosPorCodigoDoCliente(codigoDoCliente);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<Pedido> adicionarPedidos(
		@Valid @Validated @NonNull @RequestBody List<PedidoDTO> pedidosAAdicionar
	) {
		List<Pedido> pedidosAdicionados = new ArrayList<>();
		int numeroDePedidos = pedidosAAdicionar.size();
		if (numeroDePedidos > ApiDePedidosRestController.NUMERO_MAXIMO_DE_PEDIDOS_POR_REQUISICAO) {
			return pedidosAdicionados;
		}
		
		for (int p = 0; p < numeroDePedidos; p++) {
			PedidoDTO pedidoAAdicionar = pedidosAAdicionar.get(p);
			Pedido pedido = pedidoAAdicionar.converterParaPedido();
			Pedido pedidoAdicionado = this.servicoDePedidos.adicionarPedido(pedido).orElse(null);
			pedidosAdicionados.add(pedidoAdicionado);
		}
		
		return pedidosAdicionados;
	}
}
