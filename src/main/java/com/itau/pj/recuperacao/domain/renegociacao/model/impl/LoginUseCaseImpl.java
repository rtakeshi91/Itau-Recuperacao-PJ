package com.itau.pj.recuperacao.domain.renegociacao.model.impl;

import com.itau.pj.recuperacao.config.TokenProvider;
import com.itau.pj.recuperacao.domain.autenticacao.dto.input.LoginRequestDTO;
import com.itau.pj.recuperacao.domain.renegociacao.model.LoginUseCase;
import com.itau.pj.recuperacao.entrypoints.entities.Login;
import com.itau.pj.recuperacao.entrypoints.repositories.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {

    private final LoginRepository loginRepository;
    private final TokenProvider tokenProvider;

    @Override
    public String executar(LoginRequestDTO loginRequest) {
        Login usuario = loginRepository.findByLogin(loginRequest.getLogin())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        if (!loginRequest.getSenha().equals(usuario.getSenha())) {
            throw new BadCredentialsException("Senha inválida");
        }

        return tokenProvider.gerarToken(usuario.getLogin());
    }
}

