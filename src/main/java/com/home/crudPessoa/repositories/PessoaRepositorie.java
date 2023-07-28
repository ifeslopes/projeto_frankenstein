package com.home.crudPessoa.repositories;

import com.home.crudPessoa.entities.Pessoa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

public interface PessoaRepositorie extends JpaRepository<Pessoa, Integer>, JpaSpecificationExecutor<Pessoa> {
    @Transactional(readOnly = true)
    Pessoa findByEmail(String email, Sort sort);
    Pessoa findByNome(String nome, Sort sort);


}