package com.example.crudPessoa.services;

import com.example.crudPessoa.entities.Pessoa;
import com.example.crudPessoa.repositories.PessoaRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepositorie pessoaRepositorie;
    public List<Pessoa> listaTodos(){
        return  pessoaRepositorie.findAll();
    }
    public Pessoa buscarPorId(Integer id){
        Optional<Pessoa> obj =pessoaRepositorie.findById( id);
        return obj.get();
    }
    public Pessoa criarPessoa(Pessoa pessoa){
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


}
