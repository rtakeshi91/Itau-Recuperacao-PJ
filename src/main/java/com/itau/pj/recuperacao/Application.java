package com.itau.pj.recuperacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.itau.pj.recuperacao")
@EntityScan(basePackages = "com.itau.pj.recuperacao.domain.model")
@EnableJpaRepositories(basePackages = "com.itau.pj.recuperacao.infraestrutura.adapters.repository")

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
