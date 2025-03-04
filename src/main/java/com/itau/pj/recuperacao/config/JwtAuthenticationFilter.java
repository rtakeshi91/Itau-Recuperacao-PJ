package com.itau.pj.recuperacao.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter implements Filter {

    private final TokenProvider tokenProvider;

    public JwtAuthenticationFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authorizationHeader = httpRequest.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7); // Remove "Bearer "
            System.out.println("Token recebido: " + token);

            try {
                if (tokenProvider.validarToken(token)) {
                    String username = tokenProvider.getLoginDoToken(token);

                    if (username != null) {
                        System.out.println("Token válido, usuário autenticado: " + username);
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                username, null, List.of()); // Ou adicionar authorities se necessário
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));

                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                } else {
                    System.out.println("Token inválido");
                }
            } catch (Exception e) {
                System.err.println("Erro ao processar o token JWT: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhum haeder de authorization encontrado");
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
