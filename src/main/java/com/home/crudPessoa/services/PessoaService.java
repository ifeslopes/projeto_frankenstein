package com.home.crudPessoa.services;

import com.home.crudPessoa.entities.Pessoa;
import com.home.crudPessoa.entities.PessoaTeste;
import com.home.crudPessoa.enums.Perfil;
import com.home.crudPessoa.repositories.PessoaRepositorie;
import com.home.crudPessoa.repositories.PessoaTesteRepository;
import com.home.crudPessoa.repositories.spec.PessoaSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepositorie pessoaRepositorie;
    @Autowired
    private PessoaTesteRepository pessoaTesteRepository;
    @Autowired
    PessoaSpec pessoaSpec;

    private BCryptPasswordEncoder pe;

    PessoaService() {
        pe = new BCryptPasswordEncoder();
    }

    public Page<Pessoa> listaTodos() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("nome"));
        return pessoaRepositorie.findAll(pageable);
    }

    public List<PessoaTeste> listaTodosTeste() {

        return pessoaTesteRepository.findAll();
    }

    public Pessoa buscarPorId(Integer id) {
        return pessoaRepositorie.findById(id).get();
    }

    public PessoaTeste buscarPorIdTeste(Integer id) {
        return pessoaTesteRepository.findById(id).get();

    }

    public Page<Pessoa> buscarPorNome(String nome) {
        Specification<Pessoa> spec = pessoaSpec.nomeEqual(nome);
        Pageable pageable = PageRequest.of(0, 10, Sort.by("nome"));
        return pessoaRepositorie.findAll(spec, pageable);
    }

    public Page<Pessoa> buscarPorLentra(String nome) {
        Specification<Pessoa> spec = pessoaSpec.nomeLinke(nome);
        Pageable pageable = PageRequest.of(0, 10, Sort.by("nome"));

        return pessoaRepositorie.findAll(spec, pageable);
    }

    public Page<Pessoa> buscarPorFiltro(Pessoa nome) {
        Specification<Pessoa> spec = pessoaSpec.filtroDados(nome);
        Pageable pageable = PageRequest.of(0, 10, Sort.by("nome"));
        return pessoaRepositorie.findAll(spec, pageable);
    }

    public Pessoa criarPessoa(Pessoa pessoa) {
        pessoa = codificarsenha(pessoa);
        return pessoaRepositorie.save(pessoa);
    }

    public void delete(Integer id) {
        pessoaRepositorie.deleteById(id);
    }

    public Pessoa atualizaPessoa(Integer id, Pessoa pessoa) {
        Pessoa pessoaBd = pessoaRepositorie.getReferenceById(id);
        atualizaDados(pessoaBd, pessoa);
        return pessoaRepositorie.save(pessoaBd);
    }

    private void atualizaDados(Pessoa pessoaBd, Pessoa pessoa) {
        pessoaBd.setNome(pessoa.getNome());
        pessoaBd.setEmail(pessoa.getEmail());
        pessoaBd.setTelefone(pessoa.getTelefone());
        pessoaBd.setNumeroDocumneto(pessoa.getNumeroDocumneto());
    }
    public Pessoa promover(Integer id ){
        Pessoa pessoa = pessoaRepositorie.getReferenceById(id);
        pessoa.addPerfil(Perfil.ADMIN);
        return  pessoaRepositorie.save(pessoa);
    }
    public Pessoa desPromover(Integer id ){
        Pessoa pessoa = pessoaRepositorie.getReferenceById(id);
        pessoa.removePerfil(Perfil.ADMIN);
        return  pessoaRepositorie.save(pessoa);
    }

    public Pessoa codificarsenha(Pessoa pessoa){
        pessoa.setSenha(this.pe.encode(pessoa.getSenha()));
        return pessoa;

    }
}
