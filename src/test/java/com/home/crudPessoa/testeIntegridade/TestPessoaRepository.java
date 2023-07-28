package com.home.crudPessoa.testeIntegridade;

import com.home.crudPessoa.entities.PessoaTeste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestPessoaRepository extends JpaRepository<PessoaTeste,Integer> {
}
