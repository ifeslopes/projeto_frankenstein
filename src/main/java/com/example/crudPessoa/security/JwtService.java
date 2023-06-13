package com.example.crudPessoa.security;

import org.springframework.beans.factory.annotation.Value;

public class JwtService {
    @Value("${security.jwt.expiracao}")
    private String expiracao;

    @Value("${security.jwt.chave-assinatura}")
    private String chaveAssinatura;
}
