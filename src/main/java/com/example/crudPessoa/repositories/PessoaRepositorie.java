package com.example.crudPessoa.repositories;

import com.example.crudPessoa.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorie extends JpaRepository<Pessoa, Integer> {
}
