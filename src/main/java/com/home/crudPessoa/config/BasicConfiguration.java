//package com.home.crudPessoa.config;
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//
//import java.util.Collection;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Configuration
//@EnableWebSecurity
//@AllArgsConstructor
//public class BasicConfiguration extends WebSecurityConfigurerAdapter {
//
//    private final KeycloakLogoutHandler keycloakLogoutHandler;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated()
//            .and()
//                .oauth2ResourceServer().jwt().jwtAuthenticationConverter(new JwtAuthenticationConverter() {
//                    @Override
//                    protected Collection<GrantedAuthority> extractAuthorities(final Jwt jwt)
//                    {
//                        Collection<GrantedAuthority> authorities = super.extractAuthorities(jwt);
//                        Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
//                        Map<String, Object> resource = null;
//                        Collection<String> resourceRoles = null;
//                        Collection<String> realmRoles = null;
//
//                        if (resourceAccess != null
//                                && (resource = (Map<String, Object>) resourceAccess.get("feedboas-dev")) != null
//                                && (resourceRoles = (Collection<String>) resource.get("roles")) != null) {
//
//                            authorities.addAll(resourceRoles.stream()
//                                    .map(x -> new SimpleGrantedAuthority("ROLE_" + x))
//                                    .collect(Collectors.toSet()));
//                        }
//
//                        Map<String, Object> realmAccess = jwt.getClaim("realm_access");
//                        if (realmAccess != null
//                                && (realmRoles = (Collection<String>) realmAccess.get("roles")) != null) {
//
//                            authorities.addAll(realmRoles.stream()
//                                    .map(x -> new SimpleGrantedAuthority("ROLE_" + x))
//                                    .collect(Collectors.toSet()));
//                        }
//                        return authorities;
//                    }
//                });
//
//        http.oauth2Login()
//                .and()
//                .logout()
//                .addLogoutHandler(keycloakLogoutHandler)
//                .logoutSuccessUrl("/");
//    }
//}
