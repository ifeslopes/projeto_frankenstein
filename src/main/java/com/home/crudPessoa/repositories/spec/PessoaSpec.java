package com.home.crudPessoa.repositories.spec;

import com.home.crudPessoa.entities.Pessoa;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PessoaSpec {
    public  Specification<Pessoa> nomeEqual(String nome) {
        return (root, query, cb) -> cb.equal(root.get("nome"), nome);
    }

    public static Specification<Pessoa> emailEqual(String email) {
        return (root, query, cb) -> cb.equal(root.get("email"), email);
    }

    public  Specification<Pessoa> nomeLinke(String nome) {
        return (root, query, cb) -> cb.like(cb.upper(root.get("nome")), "%" + nome.toUpperCase() + "%");
    }

    public  Specification<Pessoa> filtroDados(Pessoa pessoa) {
        Specification<Pessoa> spac = Specification.where((root, query, cb) -> cb.conjunction());
        if (StringUtils.hasText(pessoa.getNome())) {
            spac = spac.and(this.nomeLinke(pessoa.getNome()));
        }

        if (StringUtils.hasText(pessoa.getEmail())) {
            spac = spac.and(emailEqual(pessoa.getEmail()));
        }
        return spac;
    }

}
