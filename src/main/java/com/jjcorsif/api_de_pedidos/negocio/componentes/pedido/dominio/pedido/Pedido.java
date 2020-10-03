package com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "pedidos")
public class Pedido {
	@Column(name = "numero_controle")
	@Id
	@JsonProperty("numeroDeControle")
	private Integer numeroDeControle;
	
	@Column(name = "data_cadastro", updatable = false)
	@JsonProperty("dataDeCadastro")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataDeCadastro;
	
	@JoinColumn(name = "id_produto", nullable = false, updatable = false)
	@JsonProperty("produto")
	@ManyToOne(cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Produto produto;
	
	@Column(nullable = false)
	@ColumnDefault(value = "1")
	@JsonProperty("quantidade")
	@NotNull
	private Integer quantidade;
	
	@Column(name = "codigo_cliente", nullable = false)
	@JsonProperty("codigoDoCliente")
	@NotEmpty
	private String codigoDoCliente;
	
	@Column(name = "valor_total", nullable = false)
	@ColumnDefault(value = "0")
	@JsonProperty("valorTotal")
	private double valorTotal;
	
	public Pedido() {
		super();
		this.dataDeCadastro = new Date();
		this.quantidade = 1;
	}
	
	public Pedido(Integer numeroDeControle, Produto produto, String codigoDoCliente) {
		this.numeroDeControle = numeroDeControle;
		this.produto = produto;
		this.codigoDoCliente = codigoDoCliente;
		this.dataDeCadastro = new Date();
		this.quantidade = 1;
		this.calcularValorTotal();
	}
	
	public Pedido(Integer numeroDeControle, Produto produto, String codigoDoCliente, Date dataDeCadastro) {
		this.numeroDeControle = numeroDeControle;
		this.produto = produto;
		this.codigoDoCliente = codigoDoCliente;
		this.dataDeCadastro = dataDeCadastro;
		this.quantidade = 1;
		this.calcularValorTotal();
	}
	
	public Pedido(Integer numeroDeControle, Produto produto, String codigoDoCliente, Integer quantidade) {
		this.numeroDeControle = numeroDeControle;
		this.produto = produto;
		this.codigoDoCliente = codigoDoCliente;
		this.dataDeCadastro = new Date();
		this.quantidade = quantidade;
		this.calcularValorTotal();
	}
	
	public Pedido(
		Integer numeroDeControle,
		Produto produto,
		String codigoDoCliente,
		Date dataDeCadastro,
		Integer quantidade
	) {
		this.numeroDeControle = numeroDeControle;
		this.produto = produto;
		this.codigoDoCliente = codigoDoCliente;
		this.dataDeCadastro = dataDeCadastro;
		this.quantidade = quantidade;
		this.calcularValorTotal();
	}
	
	public Pedido comProduto(Produto produto) {
		this.setProduto(produto);
		return this;
	}
	
	public double getValorTotal() {
		return this.valorTotal;
	}
	
	public Integer getNumeroDeControle() {
		return this.numeroDeControle;
	}
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public String getCodigoDoCliente() {
		return this.codigoDoCliente;
	}
	
	public Date getDataDeCadastro() {
		return this.dataDeCadastro;
	}
	
	public Integer getQuantidade() {
		return this.quantidade;
	}
	
	public void setNumeroDeControle(Integer numeroDeControle) {
		this.numeroDeControle = numeroDeControle;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void setCodigoDoCliente(String codigoDoCliente) {
		this.codigoDoCliente = codigoDoCliente;
	}
	
	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void calcularValorTotal() {
		double porcentagemDeDesconto = this.calcularPorcentagemDeDesconto();
		
		this.valorTotal = this.quantidade * this.produto.getPreco().getValor() * (1 - porcentagemDeDesconto);
	}
	
	private double calcularPorcentagemDeDesconto() {
		if (this.quantidade >= 10) {
			return .1;
		}
		
		if (this.quantidade > 5) {
			return .05;
		}
		
		return 0;
	}
}
