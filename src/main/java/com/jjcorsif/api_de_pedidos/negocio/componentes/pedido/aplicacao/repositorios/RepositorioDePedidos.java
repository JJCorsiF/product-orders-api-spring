package com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.aplicacao.repositorios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido.Pedido;

public interface RepositorioDePedidos {
	public List<Pedido> findAll();
	public Optional<Pedido> findById(Integer numeroDeControle);
	public List<Pedido> findByDataDeCadastro(Date dataDeCadastro);
	public List<Pedido> findAllByCodigoDoCliente(String codigoDoCliente);
	public Pedido save(Pedido pedido);
}
