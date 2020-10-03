package com.jjcorsif.api_de_pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiDePedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDePedidosApplication.class, args);
	}

}
