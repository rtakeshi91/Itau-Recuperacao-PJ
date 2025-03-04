package com.itau.pj.recuperacao.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class TokenProvider {

    private static final long EXPIRATION_TIME = 86400000; // 24 horas

    @Value("${jwt.secret}")
    private String secretKey;  // A chave secreta configurada externamente

    private Key key;

    @PostConstruct
    public void init() {
        if (secretKey == null || secretKey.isEmpty()) {
            throw new IllegalArgumentException("A chave secreta não foi configurada.");
        } else {
            // Se a chave secreta estiver em Base64, decodifique-a
            byte[] decodedKey = Base64.getDecoder().decode(secretKey);
            this.key = new SecretKeySpec(decodedKey, SignatureAlgorithm.HS256.getJcaName());
            System.out.println("Chave secreta carregada com sucesso.");
        }
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String gerarToken(String login) {
        System.out.println("Gerando token para o login: " + login);
        // Assinando o token com a chave secreta configurada
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Define a expiração do token
                .signWith(key, SignatureAlgorithm.HS256)  // Usa a chave configurada para assinar o token
                .compact();
    }

    public boolean validarToken(String token) {
        try {
            var claims = Jwts.parserBuilder()
                    .setSigningKey(key) // A chave que foi configurada no `init`
                    .build()
                    .parseClaimsJws(token) // Tenta parsear o token
                    .getBody();

            // Verifica se o token está expirado
            Date expiration = claims.getExpiration();
            return expiration.after(new Date()); // Verifica se a data de expiração é maior que a data atual

        } catch (Exception e) {
            // Log de erro para diagnóstico
            System.err.println("Erro ao validar o token JWT: " + e.getMessage());
            return false; // Retorna falso caso o token não seja válido
        }
    }

    public String getLoginDoToken(String token) {
        try {
            // Decodifica o token e retorna o login (subject) do token
            return Jwts.parserBuilder()
                    .setSigningKey(key)  // Usa a chave configurada para ler o token
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();  // Retorna o login do token (subject)
        } catch (Exception e) {
            System.err.println("Erro ao obter login do token: " + e.getMessage());
            return null;
        }
    }

    public byte[] getKey() {
        return key.getEncoded();
    }
}
