package com.jjcorsif.api_de_pedidos.ui.api.rest.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido.Pedido;
import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido.Preco;
import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido.Produto;

public class PedidoDTO {
	
	@JsonProperty("numeroDeControle")
	private Integer numeroDeControle;
	
	@JsonProperty("dataDeCadastro")
	@NotNull
	private Date dataDeCadastro;
	
	@JsonProperty("nomeDoProduto")
	private String nomeDoProduto;
	
	@JsonProperty("precoDoProduto")
	private double precoDoProduto;
	
	@JsonProperty("quantidadeDeProdutos")
	private Integer quantidadeDeProdutos;
	
	@JsonProperty("codigoDoCliente")
	private String codigoDoCliente;
	
	public PedidoDTO() {
		super();
		this.dataDeCadastro = new Date();
		this.quantidadeDeProdutos = 1;
	}
	
	public PedidoDTO(Integer numeroDeControle, String nomeDoProduto, double precoDoProduto, String codigoDoCliente) {
		this.numeroDeControle = numeroDeControle;
		this.nomeDoProduto = nomeDoProduto;
		this.precoDoProduto = precoDoProduto;
		this.codigoDoCliente = codigoDoCliente;
		this.dataDeCadastro = new Date();
		this.quantidadeDeProdutos = 1;
	}
	
	public PedidoDTO(
		Integer numeroDeControle,
		String nomeDoProduto,
		double precoDoProduto,
		String codigoDoCliente,
		Date dataDeCadastro
	) {
		this.numeroDeControle = numeroDeControle;
		this.nomeDoProduto = nomeDoProduto;
		this.precoDoProduto = precoDoProduto;
		this.codigoDoCliente = codigoDoCliente;
		this.dataDeCadastro = dataDeCadastro;
		this.quantidadeDeProdutos = 1;
	}
	
	public PedidoDTO(
		Integer numeroDeControle,
		String nomeDoProduto, 
		double precoDoProduto,
		String codigoDoCliente,
		Integer quantidadeDeProdutos
	) {
		this.numeroDeControle = numeroDeControle;
		this.nomeDoProduto = nomeDoProduto;
		this.precoDoProduto = precoDoProduto;
		this.codigoDoCliente = codigoDoCliente;
		this.dataDeCadastro = new Date();
		this.quantidadeDeProdutos = quantidadeDeProdutos;
	}
	
	public PedidoDTO(
		Integer numeroDeControle,
		String nomeDoProduto,
		double precoDoProduto,
		String codigoDoCliente,
		Date dataDeCadastro,
		Integer quantidadeDeProdutos
	) {
		this.numeroDeControle = numeroDeControle;
		this.nomeDoProduto = nomeDoProduto;
		this.precoDoProduto = precoDoProduto;
		this.codigoDoCliente = codigoDoCliente;
		this.dataDeCadastro = dataDeCadastro;
		this.quantidadeDeProdutos = quantidadeDeProdutos;
	}
	
	public Pedido converterParaPedido() {
		return new Pedido(this.numeroDeControle, new Produto(this.nomeDoProduto, new Preco(this.precoDoProduto)), this.codigoDoCliente, this.dataDeCadastro, this.quantidadeDeProdutos);
	}
	
	public Integer getNumeroDeControle() {
		return this.numeroDeControle;
	}
	
	public String getNomeDoProduto() {
		return this.nomeDoProduto;
	}
	
	public double getPrecoDoProduto() {
		return this.precoDoProduto;
	}
	
	public String getCodigoDoCliente() {
		return this.codigoDoCliente;
	}
	
	public Date getDataDeCadastro() {
		return this.dataDeCadastro;
	}
	
	public Integer getQuantidadeDeProdutos() {
		return this.quantidadeDeProdutos;
	}
	
	public void setNumeroDeControle(Integer numeroDeControle) {
		this.numeroDeControle = numeroDeControle;
	}
	
	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}
	
	public void setPrecoDoProduto(double precoDoProduto) {
		this.precoDoProduto = precoDoProduto;
	}
	
	public void setCodigoDoCliente(String codigoDoCliente) {
		this.codigoDoCliente = codigoDoCliente;
	}
	
	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	
	public void setQuantidadeDeProdutos(Integer quantidadeDeProdutos) {
		this.quantidadeDeProdutos = quantidadeDeProdutos;
	}
}
