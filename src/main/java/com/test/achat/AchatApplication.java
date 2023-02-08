package com.test.achat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
@ComponentScan("com.test.achat")
@EnableJpaRepositories
@EnableCaching
@EnableTransactionManagement
//@EntityScan
public class AchatApplication  {

	public static void main(String[] args) {
		SpringApplication.run(AchatApplication.class, args);
	}

}
