package com.home.crudPessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class CrudPessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudPessoaApplication.class, args);
	}

}
