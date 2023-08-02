package com.home.crudPessoa;

import com.home.crudPessoa.entities.PessoaTeste;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.crudPessoa.testeIntegridade.TestPessoaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ActiveProfiles("testInte")
@AutoConfigureMockMvc(addFilters = false)
public class PessoaTesteIntegridadeMockitoIT {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    TestPessoaRepository pessoaRepository;

    @BeforeEach
    void up() {
        PessoaTeste pessoa = new PessoaTeste(null,"carlos", "test@gmail.com", "3333-3333", 12504, "1234");
        pessoaRepository.save(pessoa);
    }

    @AfterEach
    void down(){
        pessoaRepository.deleteAll();
    }

    @Test
    @DisplayName("Lista todas as pessoas")
    void listaPessoas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pessoas/teste"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Salvar pessoas")
    void salvarPessoa() throws Exception {
        PessoaTeste pessoa = new PessoaTeste(null, "carlosAdd", "testAdd@gmail.com", "999-9999", 1555, "333");
        String salva = objectMapper.writeValueAsString(pessoa);
        mockMvc.perform(MockMvcRequestBuilders.post("/pessoas/teste/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(salva)
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    @DisplayName("Atualizar pessoas")
    void atualizarPessoa() throws Exception {
        PessoaTeste pessoa = new PessoaTeste(null, "carlosAdd", "testAdd@gmail.com", "999-9999", 1555, "333");
        String salva = objectMapper.writeValueAsString(pessoa);
        mockMvc.perform(MockMvcRequestBuilders.put("/pessoas/teste/7")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(salva)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    @DisplayName("Deletar pessoas")
    void deletarPessoa() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/pessoas/teste/6")
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
