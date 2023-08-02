package com.home.crudPessoa;

import com.home.crudPessoa.entities.Pessoa;
import com.home.crudPessoa.entities.PessoaTeste;
import com.home.crudPessoa.repositories.PessoaRepositorie;
import com.home.crudPessoa.repositories.PessoaTesteRepository;
import com.home.crudPessoa.repositories.spec.PessoaSpec;
import com.home.crudPessoa.services.PessoaService;
import com.home.crudPessoa.testUnutario.StubPessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class PessoaTest {
    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepositorie pessoaRepositorie;
    @Mock
    private PessoaTesteRepository pessoaTesteRepository;
    @Mock
    PessoaSpec pessoaSpec;

    private Specification<Pessoa> pessoaSpecObj;
    private Page<Pessoa> pagePessoa;

    private PessoaTeste pessoa;
    private Pessoa pessoa1;
    private BCryptPasswordEncoder pe = new BCryptPasswordEncoder();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        montarCenarioDeTeste();
    }

    StubPessoa stubPessoa = new StubPessoa();
    @Test
    @DisplayName("Deve Retorna todas as pessoas")
    void deveRetornarTodasPessoas() {
        when(pessoaRepositorie.findAll(any(Pageable.class))).thenReturn(pagePessoa);
        Page<Pessoa> listPessoa = pessoaService.listaTodos();
        assertNotNull(listPessoa);
    }
    @Test
    @DisplayName("Deve Retorna todas as pessoas Teste")
    void deveBuscarTodasPessoasTeste() {
        when(pessoaTesteRepository.findAll()).thenReturn(Collections.singletonList(pessoa));
        List<PessoaTeste> listPessoa = pessoaService.listaTodosTeste();
        assertNotNull(listPessoa);
        Assertions.assertTrue(1 <= listPessoa.size());
        Assertions.assertEquals("Nome Pessoa", listPessoa.get(0).getNome());
    }


    @Test
    void deveBuscarPessoasPorId() {
        when(pessoaRepositorie.findById(any())).thenReturn(Optional.of(pessoa1));
        Pessoa listPessoa = pessoaService.buscarPorId(1);
        assertNotNull(listPessoa);
    }
    @Test
    void deveBuscarPessoasPorIdTeste() {
        when(pessoaTesteRepository.findById(any())).thenReturn(Optional.of(pessoa));
        PessoaTeste listPessoa = pessoaService.buscarPorIdTeste(1);
        assertNotNull(listPessoa);
    }
    @Test
    void deveBuscarPessoasPorNome() {
        when(pessoaSpec.nomeEqual(any())).thenReturn(pessoaSpecObj);
        when(pessoaRepositorie.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pagePessoa);
        Page<Pessoa> response = pessoaService.buscarPorNome("Nome Usuario");
        assertNotNull(response);
        assertTrue(response.getSize() > 0);
    }



    @Test
    void deveBuscarPessoasPorFiltro() {
        when(pessoaSpec.filtroDados(any())).thenReturn(pessoaSpecObj);
        when(pessoaRepositorie.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pagePessoa);
        Page<Pessoa> response = pessoaService.buscarPorFiltro(pessoa1);
        assertNotNull(response);
        assertTrue(response.getSize() > 0);
    }

    @Test
    void deveBuscarPessoasPorLetraDeNome() {
        when(pessoaSpec.nomeLinke(any())).thenReturn(pessoaSpecObj);
        when(pessoaRepositorie.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pagePessoa);
        Page<Pessoa> response = pessoaService.buscarPorLentra("No");
        assertNotNull(response);
        assertTrue(response.getSize() > 0);
    }
    @Test
    void deveCriarPessoaNova() {
        //  pessoa1.setSenha(pe.encode(pessoa1.getSenha()));
        //when(pessoaService.codificarsenha()).thenReturn(pessoa1);
        when(pessoaRepositorie.save(any())).thenReturn(pessoa1);

        Pessoa criarPessoa = pessoaService.criarPessoa(pessoa1);
        assertNotNull(criarPessoa);
        Assertions.assertEquals("Nome Pessoa", criarPessoa.getNome());
    }
    @Test
    void  deveDeletarPessoaPorId(){
        doNothing().when(pessoaRepositorie).deleteById(1);
        pessoaService.delete(1);
        verify(pessoaRepositorie).deleteById(1);
        verify(pessoaRepositorie, times(1)).deleteById(1);
        verify(pessoaRepositorie, atLeastOnce()).deleteById(1);

    }

    private void montarCenarioDeTeste() {
        pessoa = stubPessoa.montarPessoa();
        pessoa1 = stubPessoa.montarPessoa1();
        pagePessoa = stubPessoa.montarPessoaPage();
        pessoaSpecObj = stubPessoa.montarSpecification("Nome");
    }
}

