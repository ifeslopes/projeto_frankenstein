package com.home.crudPessoa.entities;

import com.home.crudPessoa.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private int numeroDocumneto;
    private String senha;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFILS")
    private Set<Integer> perfils = new HashSet<>();

    public Pessoa() {
        addPerfil(Perfil.COMU);
    }

    public Pessoa(Integer id, String nome, String email, String telefone, int numeroDocumneto, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.numeroDocumneto = numeroDocumneto;
        this.senha = senha;
        this.perfils = perfils;
        addPerfil(Perfil.COMU);
    }

    public Set<Perfil> getPerfils() {
        return perfils.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        perfils.add(perfil.getCod());
    }
    public void removePerfil(Perfil perfil) {
        perfils.remove(perfil.getCod());
    }
}
