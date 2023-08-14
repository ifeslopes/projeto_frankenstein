//package com.home.crudPessoa.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfingKeycloack {
//   @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity){
//        return serverHttpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable)
//                .authorizeExchange(exachange -> exachange.pathMatchers("/h2-console/**")
//                .permitAll()
//                .anyExchange().authenticated()
//                ).oauth2ResourceServer((oauth) -> oauth
//                        .jwt(Customizer.withDefaults())).build();
//    }
//
//}
