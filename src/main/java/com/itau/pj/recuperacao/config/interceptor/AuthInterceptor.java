package com.itau.pj.recuperacao.config.interceptor;

import com.itau.pj.recuperacao.config.auth.TokenProvider;
import com.itau.pj.recuperacao.domain.model.Login;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    private final CacheManager cacheManager;
    private final TokenProvider tokenProvider;

    public AuthInterceptor(CacheManager cacheManager, TokenProvider tokenProvider) {
        this.cacheManager = cacheManager;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7); // Remove "Bearer "
            System.out.println("secret na preHandle(): " + tokenProvider.getSecretKey());

            try {
                // Tenta recuperar do cache primeiro
                Cache cache = cacheManager.getCache("jwtCache");
                if (cache != null) {
                    Login cachedLogin = cache.get(token, Login.class);
                    if (cachedLogin != null) {
                        System.out.println("Token recuperado do cache para usuario: " + cachedLogin.getLogin());
                        return true;
                    }
                }

                // Validar o token usando o TokenProvider
                if (tokenProvider.validarToken(token)) {
                    Claims claims = Jwts.parserBuilder()
                            .setSigningKey(tokenProvider.getKey()) // Usa a chave do TokenProvider
                            .build()
                            .parseClaimsJws(token)
                            .getBody();

                    String usuario = claims.getSubject();
                    System.out.println("Token valido para usuario: " + usuario);

                    // Salva os dados do usuario no cache
                    if (cache != null) {
                        Login login = new Login(usuario);
                        cache.put(token, login);
                        System.out.println("Usuario armazenado no cache: " + usuario);
                    }

                    return true; // Continua a requisição
                }
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                System.err.println("preHandle - Erro ao validar o token JWT: " + e.getMessage());
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            System.err.println("Cabeçalho 'Authorization' não encontrado ou inválido.");
        }
        return false; // Interrompe a requisição
    }
}
