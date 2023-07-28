package com.home.crudPessoa;

import com.home.crudPessoa.dto.PessoaResponseDTO;
import com.home.crudPessoa.dto.PessoaResquestDTO;
import com.home.crudPessoa.entities.Pessoa;
import com.home.crudPessoa.mapper.PessoaMapper;
import com.home.crudPessoa.repositories.PessoaRepositorie;
import com.home.crudPessoa.services.Pessoa2Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PessoaServiceTest {


    @InjectMocks
    private Pessoa2Service pessoaService;
    @Mock
    private PessoaRepositorie repositorie;
    @Mock
    private PessoaMapper mapper;


    private Pessoa pessoa;
    private PessoaResquestDTO pessoaResquestDTO;
    private PessoaResponseDTO pessoaResponseDTO;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.montaCenarioDeTestes();
    }

    @Test
    @DisplayName("Deve Criar Um Pessoa com sucesso")
    void devecriarPessoaComSucesso(){

        //CENARIO
        PessoaResquestDTO pessoaResquestDTO = new PessoaResquestDTO( "Teste", "maria@gmail.com", "988888888", 123456,"123");
        when(repositorie.save(any())).thenReturn(pessoa);
        when(mapper.toEntitie(any())).thenReturn(pessoa);

        //ACÃO
        PessoaResponseDTO response = pessoaService.save(pessoaResquestDTO);

        // ASSERTIVAS
        assertNotNull(response);
        assertEquals("Teste", response.getNome());
    }






    private void montaCenarioDeTestes() {
        pessoa = new Pessoa(null, "Teste", "teste@gmail.com", "988888888", 123456, "123");
        pessoaResquestDTO = new PessoaResquestDTO( "Maria Brown", "maria@gmail.com", "988888888", 123456,"123");
        pessoaResponseDTO = new PessoaResponseDTO( "Maria Brown", "maria@gmail.com", "988888888");

    }

}
