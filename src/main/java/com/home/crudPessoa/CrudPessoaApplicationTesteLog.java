package com.home.crudPessoa;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Slf4j
@SpringBootApplication()
public class CrudPessoaApplicationTesteLog {

	public static void main(String[] args) {
		String nome="AAAAAA";
		String nomeb="AAAAAABBBBBBBBBB";
		String nomeber="AAAAAABBBBBBBBBB";
		log.info("Iniciando a api {} de cadastro de pessoas {}",nome,nomeb);
		SpringApplication.run(CrudPessoaApplicationTesteLog.class, args);
		log.info("API de cadastro de pessoas iniciada e pronto para receber requisições {} -- {}", nome,nomeb);

	}

}
