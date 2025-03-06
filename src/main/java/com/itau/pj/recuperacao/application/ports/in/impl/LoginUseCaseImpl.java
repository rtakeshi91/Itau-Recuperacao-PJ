package com.itau.pj.recuperacao.application.ports.in.impl;

import com.itau.pj.recuperacao.config.auth.TokenProvider;
import com.itau.pj.recuperacao.infraestrutura.dto.in.LoginRequestDTO;
import com.itau.pj.recuperacao.application.ports.in.LoginUseCase;
import com.itau.pj.recuperacao.domain.model.Login;
import com.itau.pj.recuperacao.infraestrutura.adapters.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {

    private final LoginRepository loginRepository;
    private final TokenProvider tokenProvider;

    @Override
    public String executar(LoginRequestDTO loginRequest) {
        Login usuario = loginRepository.findByLogin(loginRequest.getLogin())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));

        if (!loginRequest.getSenha().equals(usuario.getSenha())) {
            throw new BadCredentialsException("Senha invalida");
        }

        return tokenProvider.gerarToken(usuario.getLogin());
    }
}

