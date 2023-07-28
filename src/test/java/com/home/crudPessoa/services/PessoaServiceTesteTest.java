package com.home.crudPessoa.services;

import com.home.crudPessoa.entities.PessoaTeste;
import com.home.crudPessoa.repositories.PessoaTesteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PessoaServiceTesteTest {
    @Mock
    private PessoaTesteRepository pessoaRepository;
    @Autowired
    private BCryptPasswordEncoder pe;


    private PessoaServiceTeste pessoaTeste;

    @BeforeEach
    void setUp() {
        pessoaTeste = new PessoaServiceTeste(pessoaRepository);
    }


    @Test
    void listaTodosTeste() {
        //enquando
        pessoaTeste.listaTodosTeste();
        //então
        verify(pessoaRepository).findAll();
    }

    @Test
    @Disabled
    void buscarPorIdTeste() {
    }

    @Test
    void criarPessoa() {
       //dado
        PessoaTeste p3 = new PessoaTeste(null, "Teste", "Teste@gmail.com", "99999999", 123456, pe.encode("3335555"));
        //enquando
        pessoaTeste.criarPessoa(p3);
        //então
        ArgumentCaptor<PessoaTeste> pessoaArgumentCaptor =
                ArgumentCaptor.forClass(PessoaTeste.class);
        verify(pessoaRepository).save(pessoaArgumentCaptor.capture());

        PessoaTeste pessoaCaptor = pessoaArgumentCaptor.getValue();
        assertThat(pessoaCaptor).isEqualTo(p3);

    }

    @Test
    @Disabled
    void delete() {
    }
}