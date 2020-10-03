package com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.aplicacao.excecoes.handlers;

import com.jjcorsif.api_de_pedidos.negocio.componentes.pedido.aplicacao.excecoes.ExcecaoNumeroMaximoDePedidosPorRequisicaoFoiUltrapassado;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcecaoNumeroMaximoDePedidosPorRequisicaoFoiUltrapassadoHandler {
	
	@ExceptionHandler(ExcecaoNumeroMaximoDePedidosPorRequisicaoFoiUltrapassado.class)
	@ResponseStatus(value = HttpStatus.PAYLOAD_TOO_LARGE, reason = "O número máximo de pedidos por requisição foi ultrapassado.")
	public ExcecaoNumeroMaximoDePedidosPorRequisicaoFoiUltrapassado onPayloadTooLarge(
		ExcecaoNumeroMaximoDePedidosPorRequisicaoFoiUltrapassado excecao
	) {
		return excecao;
	}
}
