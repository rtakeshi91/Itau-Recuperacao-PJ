package com.itau.pj.recuperacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()  // Libera o H2 Console
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))  // Desativa CSRF apenas para o H2
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions
                                .sameOrigin())  // Permite apenas se vier da mesma origem
                );

        return http.build();
    }
}
