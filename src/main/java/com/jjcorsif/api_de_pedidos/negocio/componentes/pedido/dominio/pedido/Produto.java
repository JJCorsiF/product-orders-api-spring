package com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.dominio.pedido;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "produtos")
public class Produto {
	
	@Column(name="id_produto", columnDefinition = "BINARY(16)")
	@Id
	@JsonProperty("id")
	private UUID id;
	
	@Column(nullable = false)
	@JsonProperty("nome")
	@NotEmpty
	private String nome;
	
	@Embedded
	@JsonProperty("preco")
	private Preco preco;
	
	public Produto() {
		super();
	}
	
	public Produto(UUID id, String nome, Preco preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto(String nome, Preco preco) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.preco = preco;
	}
	
	public UUID getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Preco getPreco() {
		return this.preco;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	public void setPreco(Preco preco) {
		this.preco = preco;
	}
}
