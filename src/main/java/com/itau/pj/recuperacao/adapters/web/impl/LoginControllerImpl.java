package com.itau.pj.recuperacao.adapters.web.impl;

import com.itau.pj.recuperacao.adapters.web.LoginController;
import com.itau.pj.recuperacao.domain.autenticacao.dto.input.LoginRequestDTO;
import com.itau.pj.recuperacao.domain.renegociacao.service.LoginService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@SecurityRequirement(name = "none") // Permite acesso sem autenticação no Swagger
public class LoginControllerImpl implements LoginController {

    private final LoginService loginService;

    @Override
    public ResponseEntity<String> autenticar(@RequestBody LoginRequestDTO loginRequest) {
        String token = loginService.autenticar(loginRequest);
        return ResponseEntity.ok(token);
    }
}


