package com.example.crudPessoa.repositories;

import com.example.crudPessoa.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PessoaRepositorie extends JpaRepository<Pessoa, Integer> {
    @Transactional(readOnly = true)
    Pessoa findByEmail(String email);

}