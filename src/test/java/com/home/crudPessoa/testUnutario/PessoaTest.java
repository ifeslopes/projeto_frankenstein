package com.home.crudPessoa.testUnutario;

import com.home.crudPessoa.entities.PessoaTeste;
import com.home.crudPessoa.repositories.PessoaTesteRepository;
import com.home.crudPessoa.services.PessoaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class PessoaTest {
    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaTesteRepository pessoaRepositorie;

    private PessoaTeste pessoa;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        montarCenarioDeTeste();
    }

    StubPessoa stubPessoa = new StubPessoa();

    @Test
    @DisplayName("Deve Retorna todas as pessoas")
    void deveBuscarTodasPessoas() {
        Pageable pageable = PageRequest.of(1, 1, Sort.by("nome"));
        when(pessoaRepositorie.findAll()).thenReturn(Collections.singletonList(pessoa));
        List<PessoaTeste> listPessoa = pessoaService.listaTodosTeste();
        assertNotNull(listPessoa);
        Assertions.assertTrue(1 <= listPessoa.size());
        Assertions.assertEquals("Nome Pessoa", listPessoa.get(0).getNome());
    }

    @Test
    void deveBuscarPessoasPorId() {
        when(pessoaRepositorie.findById(1)).thenReturn(Optional.of(pessoa));
        List<PessoaTeste> listPessoa = pessoaService.listaTodosTeste();
        assertNotNull(listPessoa);
    }

    private void montarCenarioDeTeste() {
        pessoa = stubPessoa.montarPessoa();
    }
}
