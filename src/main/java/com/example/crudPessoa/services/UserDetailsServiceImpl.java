package com.example.crudPessoa.services;

import com.example.crudPessoa.entities.Pessoa;
import com.example.crudPessoa.repositories.PessoaRepositorie;
import com.example.crudPessoa.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
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
        Pessoa cli = repo.findByEmail(email);
        if (cli == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfils());
    }
}
