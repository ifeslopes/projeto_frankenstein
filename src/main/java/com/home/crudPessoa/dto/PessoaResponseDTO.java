package com.home.crudPessoa.dto;

import com.home.crudPessoa.entities.Pessoa;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PessoaResponseDTO {

    private String nome;
    private String email;
    private String telefone;

    public PessoaResponseDTO(Pessoa pessoa){

//                 PessoaResponseDTO.builder()
//                .nome(pessoa.getNome())
//                .email(pessoa.getEmail())
//                .telefone(pessoa.getTelefone())
//                .build();
//


        this.setNome(pessoa.getNome());
                this.setTelefone(pessoa.getTelefone());
                this.setEmail(pessoa.getEmail());

    }
    public PessoaResponseDTO(){}


}
