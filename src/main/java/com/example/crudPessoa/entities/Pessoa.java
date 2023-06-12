package com.example.crudPessoa.entities;

import com.example.crudPessoa.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String email;
    @JsonIgnore
    private String telefone;
    private int numeroDocumneto;
    private String senha;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFILS")
    private Set<Integer> perfils = new HashSet<>();

    public Pessoa() {
        addPerfil(Perfil.COMU);
    }

    public Pessoa(UUID id, String nome, String email, String telefone, int numeroDocumneto, String senha) {
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
}
