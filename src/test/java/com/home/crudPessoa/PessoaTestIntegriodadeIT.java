package com.home.crudPessoa;

import com.home.crudPessoa.entities.Pessoa;
import com.home.crudPessoa.entities.PessoaTeste;
import com.home.crudPessoa.testeIntegridade.TestPessoaRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PessoaTestIntegriodadeIT {

    @LocalServerPort
    private int port;
    private String baseUrl = "http://localhost";

    private static RestTemplate restTemplate;

    @Autowired
    private TestPessoaRepository pessoaRepositoryRepository;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setup() {
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/pessoas");
    }

    @Test
    public void testePostPessoa() {
        Pessoa pessoa = new Pessoa(null, "carlos", "test@gmail.com", "3333-3333", 12504, "1234");
        Pessoa response = restTemplate.postForObject(baseUrl + "/teste/", pessoa, Pessoa.class);
        assertEquals("carlos", response.getNome());
        assertEquals(3, pessoaRepositoryRepository.findAll().size());
    }

    @Test
    public void testGetPessoas() {

        List<PessoaTeste> pessoas = restTemplate.getForObject(baseUrl + "/teste", List.class);
        assertEquals(2, pessoas.size());
        assertEquals(2, pessoaRepositoryRepository.findAll().size());
    }

    @Test
    public void testFindProductById() {
        PessoaTeste pessoa = restTemplate.getForObject(baseUrl + "/teste/{id}", PessoaTeste.class, 1);
        assertAll(() -> assertNotNull(pessoa),
                () -> assertEquals(1, pessoa.getId()),
                () -> assertEquals("Teste", pessoa.getNome())
        );
    }

    @Test
    public void testUpdateProduct() {
        PessoaTeste pessoa = new PessoaTeste(null, "carlos", "test@gmail.com", "3333-3333", 12504, null);
        restTemplate.put(baseUrl + "/teste/{id}", pessoa, 2);
        PessoaTeste pessoaBD = pessoaRepositoryRepository.findById(2).get();
        assertAll(
                () -> assertNotNull(pessoaBD),
                () -> assertEquals(12504, pessoaBD.getNumeroDocumneto())
        );
    }

    @Test
    public void testDeleteProduct() {
        int contado = pessoaRepositoryRepository.findAll().size();
        assertEquals(3, contado);
        restTemplate.delete(baseUrl + "/teste/{id}", 2);
        assertEquals(2, pessoaRepositoryRepository.findAll().size());
    }
}
