package com.home.crudPessoa.mapper;

import com.home.crudPessoa.dto.PessoaResponseDTO;
import com.home.crudPessoa.dto.PessoaResquestDTO;
import com.home.crudPessoa.entities.Pessoa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor

public class PessoaMapper {

    public Pessoa toEntitie(PessoaResquestDTO resquestDTO ){
       return Pessoa
               .builder()
               .nome(resquestDTO.getNome())
               .email(resquestDTO.getEmail())
               .senha(resquestDTO.getSenha())
               .telefone(resquestDTO.getTelefone())
               .numeroDocumneto(resquestDTO.getNumeroDocumneto())
               .perfils(Set.of(1))
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
