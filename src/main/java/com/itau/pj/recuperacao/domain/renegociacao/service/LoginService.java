package com.itau.pj.recuperacao.domain.renegociacao.service;

import com.itau.pj.recuperacao.domain.autenticacao.dto.input.LoginRequestDTO;

public interface LoginService {
    String autenticar(LoginRequestDTO loginRequest);
}

