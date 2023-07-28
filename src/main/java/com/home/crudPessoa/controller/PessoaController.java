package com.home.crudPessoa.controller;

import com.home.crudPessoa.dto.PessoaResponseDTO;
import com.home.crudPessoa.dto.PessoaResquestDTO;
import com.home.crudPessoa.entities.Pessoa;
import com.home.crudPessoa.entities.PessoaTeste;
import com.home.crudPessoa.repositories.PessoaTesteRepository;
import com.home.crudPessoa.services.Pessoa2Service;
import com.home.crudPessoa.services.PessoaService;
import com.home.crudPessoa.services.PessoaServiceTeste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaServiceTeste pessoaServiceTeste;

    @Autowired
    private Pessoa2Service pessoa2Service;
    @Autowired
    private PessoaTesteRepository pessoaTesteRepository;


    @GetMapping
    public ResponseEntity<Page<Pessoa>> mostraPessoas() {
        Page<Pessoa> list = pessoaService.listaTodos();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/teste")
    public ResponseEntity<List<PessoaTeste>> mostraPessoasteste() {
        List<PessoaTeste> list = pessoaServiceTeste.listaTodosTeste();
        return ResponseEntity.ok().body(list);

    }

    // @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Integer id) {
        Pessoa obj = pessoaService.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/teste/{id}")
    public ResponseEntity<PessoaTeste> buscarPorIdTeste(@PathVariable Integer id) {
        PessoaTeste obj = pessoaServiceTeste.buscarPorIdTeste(id);
        return ResponseEntity.ok().body(obj);
    }


    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Page<Pessoa>> buscarPorNome(@PathVariable String nome) {
        Page<Pessoa> obj = pessoaService.buscarPorNome(nome);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/letra/{nome}")
    public ResponseEntity<Page<Pessoa>> buscarPorLetra(@PathVariable String nome) {
        Page<Pessoa> obj = pessoaService.buscarPorLentra(nome);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/filtro/")
    public ResponseEntity<Page<Pessoa>> buscarPorFiltro(@ModelAttribute Pessoa pessoa) {
        Page<Pessoa> obj = pessoaService.buscarPorFiltro(pessoa);
        return ResponseEntity.ok().body(obj);
    }


    // @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PessoaResponseDTO save(@RequestBody PessoaResquestDTO resquestDTO) {

        PessoaResponseDTO pessoaResponseDTO = pessoa2Service.save(resquestDTO);

        return pessoaResponseDTO;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/teste/")
    public PessoaTeste save(@RequestBody PessoaTeste pessoaTeste) {

        PessoaTeste pessoaTesteResquest = pessoaTesteRepository.save(pessoaTeste);

        return pessoaTeste;
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

    @PutMapping(value = "/teste/{id}")
    public ResponseEntity<PessoaTeste> atualizarTeste(@PathVariable Integer id, @RequestBody PessoaTeste pessoa) {
        pessoa = pessoaServiceTeste.atualizaPessoa(id, pessoa);
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

    //   @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/teste/{id}")
    public ResponseEntity<String> deleteteste(@PathVariable Integer id) {
        return ResponseEntity.ok().body(pessoaServiceTeste.delete(id));
    }


}
