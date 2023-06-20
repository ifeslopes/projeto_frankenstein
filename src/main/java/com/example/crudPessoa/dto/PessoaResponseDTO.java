package com.example.crudPessoa.dto;

import com.example.crudPessoa.entities.Pessoa;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class PessoaResponseDTO {

    private String nome;
    private String email;
    private String telefone;

    public PessoaResponseDTO(Pessoa pessoa){
        PessoaResponseDTO pessoaResponseDTO =new PessoaResponseDTO();
        BeanUtils.copyProperties(pessoa, pessoaResponseDTO);

    }
    public PessoaResponseDTO(){}


}
