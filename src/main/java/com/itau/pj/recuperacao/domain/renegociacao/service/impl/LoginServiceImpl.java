package com.itau.pj.recuperacao.domain.renegociacao.service.impl;

import com.itau.pj.recuperacao.domain.autenticacao.dto.input.LoginRequestDTO;
import com.itau.pj.recuperacao.domain.renegociacao.model.LoginUseCase;
import com.itau.pj.recuperacao.domain.renegociacao.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginUseCase loginUseCase;

    @Override
    public String autenticar(LoginRequestDTO loginRequest) {
        return loginUseCase.executar(loginRequest);
    }
}

