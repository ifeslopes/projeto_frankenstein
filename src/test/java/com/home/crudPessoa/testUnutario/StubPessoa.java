package com.home.crudPessoa.testUnutario;

import com.home.crudPessoa.entities.Pessoa;
import com.home.crudPessoa.entities.PessoaTeste;
import com.home.crudPessoa.enums.Perfil;
import com.home.crudPessoa.repositories.spec.PessoaSpec;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collections;
import java.util.List;

public class StubPessoa {
    @Autowired
    PessoaSpec pessoaSpec;

    public StubPessoa() {
        pessoaSpec = new PessoaSpec();
    }

    public PessoaTeste montarPessoa(){
          PessoaTeste pessoa = PessoaTeste
                .builder()
                .nome("Nome Pessoa")
                .telefone("12345678")
                .numeroDocumneto(1452356)
                .senha("123")
                .email("email@gmail.com")
                .id(1)
                .build();

        return pessoa;

    }
    public Pessoa montarPessoa1(){
        Pessoa pessoa = Pessoa
                .builder()
                .nome("Nome Pessoa")
                .telefone("12345678")
                .numeroDocumneto(1452356)
                .senha("123")
                .email("email@gmail.com")
                .id(1)
                .perfils(Collections.singleton(Perfil.COMU.getCod()))
                .build();

        return pessoa;

    }
    public Page<Pessoa> montarPessoaPage(){
        Pessoa pessoa = Pessoa
                .builder()
                .nome("Nome Pessoa")
                .telefone("12345678")
                .numeroDocumneto(1452356)
                .senha("123")
                .email("email@gmail.com")
                .id(1)
                .build();

        return  new PageImpl<>(List.of(pessoa));

    }
    public Specification<Pessoa>montarSpecification(String nome){
        return pessoaSpec.nomeLinke(nome);
    }
}
