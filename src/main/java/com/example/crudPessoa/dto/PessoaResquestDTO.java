package com.example.crudPessoa.dto;

import com.example.crudPessoa.entities.Pessoa;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
public class PessoaResquestDTO {

    private String nome;
    private String email;
    private String telefone;
    private int numeroDocumneto;
    private String senha;


}
