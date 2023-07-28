package com.home.crudPessoa.services;

import com.home.crudPessoa.dto.PessoaResponseDTO;
import com.home.crudPessoa.dto.PessoaResquestDTO;
import com.home.crudPessoa.entities.Pessoa;
import com.home.crudPessoa.exception.DadosInvalidosEception;
import com.home.crudPessoa.mapper.PessoaMapper;
import com.home.crudPessoa.repositories.PessoaRepositorie;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Pessoa2Service {
    @Autowired
    private PessoaRepositorie pessoaRepositorie;

    private PessoaMapper mapper;


    public PessoaResponseDTO save(PessoaResquestDTO resquestDTO) {

        if (resquestDTO == null) {
            throw new DadosInvalidosEception("Dados invalidos");
        }
        Pessoa pessoa = mapper.toEntitie(resquestDTO);
        pessoaRepositorie.save(pessoa);
        return new PessoaResponseDTO(pessoa);
    }

//    public PessoaResponseDTO save(PessoaResquestDTO resquestDTO){
//        Pessoa pessoa = mapper.toEntitie(resquestDTO);
//        pessoaRepositorie.save(pessoa);
//        return mapper.toResponse(pessoa);
//    }

}
