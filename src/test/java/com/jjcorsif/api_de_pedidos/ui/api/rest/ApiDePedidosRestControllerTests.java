package com.jjcorsif.api_de_pedidos.ui.api.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcorsif.api_de_pedidos.ui.api.rest.dtos.PedidoDTO;

@WebMvcTest({ApiDePedidosRestController.class})
public class ApiDePedidosRestControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ApiDePedidosRestController apiDePedidosRestController;
	
	@Test
	public void todosOsPedidosSaoRetornadosCorretamente() throws Exception {
		this.mockMvc.perform(get("/pedidos").contentType("application/json;charset=utf-8")).andExpect(status().isOk());
	}
	
	@Test
	public void osPedidosSaoAdicionadosCorretamente() throws Exception {
		Integer numeroDeControle = (new Random()).nextInt();
		String nomeDoProduto = "Um produto interessante";
		double preco = 500.0;
		String codigoDoCliente = "cliente123";
		PedidoDTO pedido = new PedidoDTO(numeroDeControle, nomeDoProduto, preco, codigoDoCliente);
		List<PedidoDTO> pedidos = new ArrayList<>();
		pedidos.add(pedido);
		
		this.mockMvc.perform(
			post("/pedidos")
			.contentType("application/json;charset=utf-8")
			.content(asJsonString(pedidos))
		)
		.andExpect(status().isCreated());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
