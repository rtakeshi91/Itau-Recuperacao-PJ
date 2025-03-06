package com.itau.pj.recuperacao.infraestrutura.services.impl;

import com.itau.pj.recuperacao.infraestrutura.dto.in.LoginRequestDTO;
import com.itau.pj.recuperacao.application.ports.in.LoginUseCase;
import com.itau.pj.recuperacao.infraestrutura.services.LoginService;
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

