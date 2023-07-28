package com.home.crudPessoa.testUnutario;

import com.home.crudPessoa.entities.PessoaTeste;

public class StubPessoa {
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
}
