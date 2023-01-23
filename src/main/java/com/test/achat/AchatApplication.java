package com.test.achat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.test.achat")
@EnableJpaRepositories
public class AchatApplication {

	public static void main(String[] args) {
		SpringApplication.run(AchatApplication.class, args);
	}

}
