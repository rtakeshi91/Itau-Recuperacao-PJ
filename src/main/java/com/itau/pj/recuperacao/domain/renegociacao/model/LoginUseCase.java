package com.itau.pj.recuperacao.domain.renegociacao.model;

import com.itau.pj.recuperacao.domain.autenticacao.dto.input.LoginRequestDTO;

public interface LoginUseCase {
    String executar(LoginRequestDTO loginRequest);
}
