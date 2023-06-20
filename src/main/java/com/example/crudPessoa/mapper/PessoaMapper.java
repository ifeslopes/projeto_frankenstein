package com.example.crudPessoa.mapper;

import com.example.crudPessoa.dto.PessoaResponseDTO;
import com.example.crudPessoa.dto.PessoaResquestDTO;
import com.example.crudPessoa.entities.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public Pessoa toEntitie(PessoaResquestDTO resquestDTO ){
       return Pessoa
               .builder()
               .nome(resquestDTO.getNome())
               .email(resquestDTO.getEmail())
               .senha(resquestDTO.getSenha())
               .build();
    }


    public PessoaResponseDTO toResponse(Pessoa pessoa){
       return PessoaResponseDTO
                .builder()
                .nome(pessoa.getNome())
                .email(pessoa.getEmail())
                .telefone(pessoa.getTelefone())
                .build();


    }

    //    public Pessoa toEntitie(PessoaResquestDTO resquestDTO ){
//        Pessoa pessoa =new Pessoa();
//        pessoa.setNome(resquestDTO.getNome());
//        return pessoa;
//    }
}
