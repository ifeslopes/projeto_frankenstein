package com.example.crudPessoa.repositories;

import com.example.crudPessoa.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepositorie extends JpaRepository<Pessoa, UUID> {
}
