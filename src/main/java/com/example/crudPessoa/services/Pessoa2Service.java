package com.example.crudPessoa.services;

import com.example.crudPessoa.dto.PessoaResponseDTO;
import com.example.crudPessoa.dto.PessoaResquestDTO;
import com.example.crudPessoa.entities.Pessoa;
import com.example.crudPessoa.mapper.PessoaMapper;
import com.example.crudPessoa.repositories.PessoaRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class Pessoa2Service {
    @Autowired
    private PessoaRepositorie pessoaRepositorie;
    @Autowired
    private PessoaMapper mapper;

    public PessoaResponseDTO save(PessoaResquestDTO resquestDTO){
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
