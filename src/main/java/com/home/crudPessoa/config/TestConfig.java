package com.home.crudPessoa.config;

import com.home.crudPessoa.entities.PessoaTeste;
import com.home.crudPessoa.repositories.PessoaTesteRepository;
import com.home.crudPessoa.repositories.PessoaRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Configuration
@Profile("testInte")
@Service
public class TestConfig implements CommandLineRunner {
    @Autowired
    private PessoaRepositorie pessoaRepositorie;
    @Autowired
    private PessoaTesteRepository pessoaTesteRepository;
    @Autowired
    private BCryptPasswordEncoder pe;

    @Override
    public void run(String... args) throws Exception {
//        Pessoa p1 = new Pessoa (null, "Maria Brown", "maria@gmail.com", "988888888", 123456,pe.encode("123"));
//       p1.addPerfil(Perfil.COMU);
//        Pessoa p2 = new Pessoa (null, "Alex Green", "alex@gmail.com", "977777777", 123456,pe.encode("321"));
//        p2.addPerfil(Perfil.ADMIN);
//        pessoaRepositorie.saveAll(Arrays.asList(p1, p2));
//
        //Teste
        PessoaTeste p3 = new PessoaTeste (null, "Teste", "Teste@gmail.com", "99999999", 123456,pe.encode("333"));
        PessoaTeste p4 = new PessoaTeste (null, "Teste1", "Teste1@gmail.com", "999999991", 123456,pe.encode("3331"));


        pessoaTesteRepository.saveAll(Arrays.asList(p3,p4));
    }
}
