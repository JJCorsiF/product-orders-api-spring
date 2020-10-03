package com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.aplicacao.excecoes.handlers;

import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.aplicacao.excecoes.ExcecaoPedidoJaExiste;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcecaoPedidoJaExisteHandler {
	
	@ExceptionHandler(ExcecaoPedidoJaExiste.class)
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Já existe um pedido com o número de controle informado.")
	public ExcecaoPedidoJaExiste onConflict(ExcecaoPedidoJaExiste excecao) {
		return excecao;
	}
}
