package com.example.crudPessoa.services;

import com.example.crudPessoa.entities.Pessoa;
import com.example.crudPessoa.enums.Perfil;
import com.example.crudPessoa.repositories.PessoaRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepositorie pessoaRepositorie;
    @Autowired
    private BCryptPasswordEncoder pe;
    public List<Pessoa> listaTodos(){
        return  pessoaRepositorie.findAll();
    }
    public Pessoa buscarPorId(Integer id){
        Optional<Pessoa> obj =pessoaRepositorie.findById( id);
        return obj.get();
    }
    public Pessoa criarPessoa(Pessoa pessoa){
       pessoa = codificarsenha(pessoa);
        return pessoaRepositorie.save(pessoa);
    }

    public void delete(Integer id){
        pessoaRepositorie.deleteById(id);
    }

    public Pessoa atualizaPessoa(Integer id, Pessoa pessoa ){
        Pessoa pessoaBd = pessoaRepositorie.getReferenceById(id);
        atualizaDados(pessoaBd, pessoa);
        return  pessoaRepositorie.save(pessoaBd);
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
        pessoa.setSenha(pe.encode(pessoa.getSenha()));
        return pessoa;

    }
}
