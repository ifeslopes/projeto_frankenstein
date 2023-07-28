package com.home.crudPessoa.dto;

import com.home.crudPessoa.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaResquestDTO {

    private String nome;
    private String email;
    private String telefone;
    private int numeroDocumneto;
    private String senha;


    public Pessoa toEntitie(PessoaResquestDTO resquestDTO) {
        return Pessoa
                .builder()
                .nome(resquestDTO.getNome())
                .email(resquestDTO.getEmail())
                .senha(resquestDTO.getSenha())
                .telefone(resquestDTO.getTelefone())
                .numeroDocumneto(resquestDTO.getNumeroDocumneto())
                .build();
    }
}
