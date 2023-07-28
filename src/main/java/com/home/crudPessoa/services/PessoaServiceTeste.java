package com.home.crudPessoa.services;

import com.home.crudPessoa.entities.Pessoa;
import com.home.crudPessoa.entities.PessoaTeste;
import com.home.crudPessoa.repositories.PessoaTesteRepository;
import com.home.crudPessoa.enums.Perfil;
import com.home.crudPessoa.repositories.PessoaRepositorie;
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
import java.util.Optional;

@Service
public class PessoaServiceTeste {

    @Autowired
    private PessoaRepositorie pessoaRepositorie;

    private PessoaTesteRepository pessoaTesteRepository;
    @Autowired
    private BCryptPasswordEncoder pe;



    public PessoaServiceTeste(PessoaTesteRepository pessoaRepository) {
    this.pessoaTesteRepository = pessoaRepository;
    }


    public List<PessoaTeste> listaTodosTeste() {

        return pessoaTesteRepository.findAll();
    }

    public PessoaTeste buscarPorIdTeste(Integer id) {
        Optional<PessoaTeste> obj = pessoaTesteRepository.findById(id);
        return obj.get();
    }

    public Page<Pessoa> buscarPorNome(String nome) {
        Specification<Pessoa> spec = PessoaSpec.nomeEqual(nome);
        Pageable pageable = PageRequest.of(0, 10, Sort.by("nome"));
        Page<Pessoa> pessoa = pessoaRepositorie.findAll(spec, pageable);
        return pessoa;
    }

    public Page<Pessoa> buscarPorLentra(String nome) {
        Specification<Pessoa> spec = PessoaSpec.nomeLinke(nome);

        Pageable pageable = PageRequest.of(0, 10, Sort.by("nome"));

        Page<Pessoa> pessoa = pessoaRepositorie.findAll(spec, pageable);

        return pessoa;
    }

    public Page<Pessoa> buscarPorFiltro(Pessoa nome) {
        Specification<Pessoa> spec = PessoaSpec.filtroDados(nome);
        Pageable pageable = PageRequest.of(0, 10, Sort.by("nome"));
        Page<Pessoa> pessoa = pessoaRepositorie.findAll(spec, pageable);
        return pessoa;
    }

    public PessoaTeste criarPessoa(PessoaTeste pessoa) {
     //   pessoa = codificarsenha(pessoa);
        return pessoaTesteRepository.save(pessoa);
    }

    public String delete(Integer id) {
        pessoaTesteRepository.deleteById(id);
        return id+" Deletado com sucesso!";
    }

    public PessoaTeste atualizaPessoa(Integer id, PessoaTeste pessoa) {
        PessoaTeste pessoaBd = pessoaTesteRepository.getReferenceById(id);
        atualizaDados(pessoaBd, pessoa);
        return pessoaTesteRepository.save(pessoaBd);
    }

    private void atualizaDados(PessoaTeste pessoaBd, PessoaTeste pessoa) {
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

    public PessoaTeste codificarsenha(PessoaTeste pessoa){
        pessoa.setSenha(pe.encode(pessoa.getSenha()));
        return pessoa;

    }
}
