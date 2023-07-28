package com.home.crudPessoa.services;

import com.home.crudPessoa.entities.Pessoa;
import com.home.crudPessoa.repositories.PessoaRepositorie;
import com.home.crudPessoa.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {
    @Autowired
    PessoaRepositorie repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Pessoa cli = repo.findByEmail(email, Sort.by("nome"));
        if (cli == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfils());
    }
}
