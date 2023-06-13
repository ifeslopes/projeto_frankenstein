package com.example.crudPessoa.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class JWTUtil {
    @Value("${jwt.secret}")
    private String expiration;

    @Value("${jwt.expiration}")
    private String secret;


    public String genereteToken(String username) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.SECOND, 60);
        cal.getTime();

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(cal.getTime())
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }
}
