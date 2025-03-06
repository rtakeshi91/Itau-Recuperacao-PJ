package com.itau.pj.recuperacao.infraestrutura.services;

import com.itau.pj.recuperacao.infraestrutura.dto.in.LoginRequestDTO;

public interface LoginService {
    String autenticar(LoginRequestDTO loginRequest);
}

