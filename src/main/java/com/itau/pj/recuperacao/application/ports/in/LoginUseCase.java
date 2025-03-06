package com.itau.pj.recuperacao.application.ports.in;

import com.itau.pj.recuperacao.infraestrutura.dto.in.LoginRequestDTO;

public interface LoginUseCase {
    String executar(LoginRequestDTO loginRequest);
}
