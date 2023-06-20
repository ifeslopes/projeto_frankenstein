package com.example.crudPessoa.controller;

import com.example.crudPessoa.dto.PessoaResponseDTO;
import com.example.crudPessoa.dto.PessoaResquestDTO;
import com.example.crudPessoa.entities.Pessoa;
import com.example.crudPessoa.services.Pessoa2Service;
import com.example.crudPessoa.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private Pessoa2Service pessoa2Service;


    @GetMapping
    public ResponseEntity<List<Pessoa>> mostraPessoas() {
        List<Pessoa> list = pessoaService.listaTodos();
        return ResponseEntity.ok().body(list);

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Integer id) {
        Pessoa obj = pessoaService.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PessoaResponseDTO save( @RequestBody PessoaResquestDTO resquestDTO){

        return pessoa2Service.save(resquestDTO);
    }


//    @PreAuthorize("hasAnyRole('ADMIN')")
//    @PostMapping
//    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
//        pessoa = pessoaService.criarPessoa(pessoa);
//
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(pessoa.getId()).toUri();
//        return ResponseEntity.created(uri).body(pessoa);
//    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
        pessoa = pessoaService.atualizaPessoa(id, pessoa);
        return ResponseEntity.ok().body(pessoa);
    }

    @PutMapping(value = "/promover/{id}")
    public ResponseEntity<Pessoa> promover(@PathVariable Integer id) {
        Pessoa pessoa = pessoaService.promover(id);
        return ResponseEntity.ok().body(pessoa);
    }
    @PutMapping(value = "/despromover/{id}")
    public ResponseEntity<Pessoa> despromover(@PathVariable Integer id) {
        Pessoa pessoa = pessoaService.desPromover(id);
        return ResponseEntity.ok().body(pessoa);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
