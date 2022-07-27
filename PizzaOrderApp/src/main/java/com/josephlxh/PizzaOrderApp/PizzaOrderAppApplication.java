package com.josephlxh.PizzaOrderApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.josephlxh.PizzaOrderApp")
public class PizzaOrderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaOrderAppApplication.class, args);
	}
}
