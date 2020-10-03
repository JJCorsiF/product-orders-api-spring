package com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.aplicacao.repositorios;

import java.util.Date;
import java.util.List;

import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("pedidos.jpa")
public interface RepositorioDePedidosJpa extends JpaRepository<Pedido, Integer>, RepositorioDePedidos
{
	@Query("select p from Pedido p where p.dataDeCadastro = ?1")
	List<Pedido> findByDataDeCadastro(Date dataDeCadastro);
	
	@Query("select p from Pedido p where p.codigoDoCliente = ?1")
	List<Pedido> findAllByCodigoDoCliente(String codigoDoCliente);
}
