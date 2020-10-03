package com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.ColumnDefault;

@Embeddable
public class Preco {
	
	@Column(nullable = false)
	@ColumnDefault(value = "'R$'")
	@JsonProperty("moeda")
	@NotEmpty
	private String moeda;
	
	@Column(nullable = false)
	@ColumnDefault(value = "0")
	@JsonProperty("valor")
	private double valor;
	
	public Preco() {
		
	}
	
	public Preco(double valor) {
		this.moeda = "R$";
		this.valor = valor;
	}
	
	public Preco(String moeda, double valor) {
		this.moeda = moeda;
		this.valor = valor;
	}
	
	public String getMoeda() {
		return this.moeda;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
}
