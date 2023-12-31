package com.home.crudPessoa.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class JWTUtil {
    @Value("${jwt.expiration}")
    private int expiration;

    @Value("${jwt.secret}")
    private String secret;


    public String genereteToken(String username) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.SECOND, expiration);
        cal.getTime();

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(cal.getTime())
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }
    public boolean tokenValido(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            String username = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());
            if (username != null && expirationDate != null && now.before(expirationDate)) {
                return true;
            }
        }
        return false;
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        }
        catch (Exception e) {
            return null;
        }
    }
}
