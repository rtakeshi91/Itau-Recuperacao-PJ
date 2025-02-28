package com.itau.pj.recuperacao.config.interceptor;

import com.itau.pj.recuperacao.entrypoints.entities.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import java.security.Key;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    private final CacheManager cacheManager;
    private final String jwtSecret = "seuSegredoSeguroAqui";

    public AuthInterceptor(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7); // Remove "Bearer "

            try {
                Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(token)
                        .getBody();

                String login = claims.get("login", String.class);
                String senha = claims.get("senha", String.class);

                // Armazenar em cache
                Cache cache = cacheManager.getCache("jwtCache");
                if (cache != null) {
                    cache.put(token, new Usuario(login, senha));
                }

                return true; // Continua a requisição
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false; // Interrompe a requisição
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false; // Interrompe a requisição
        }
    }
}
