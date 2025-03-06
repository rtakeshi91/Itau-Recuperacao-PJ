package com.itau.pj.recuperacao.infraestrutura.controllers;

import com.itau.pj.recuperacao.infraestrutura.dto.in.LoginRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "Autenticacao", description = "Endpoints para autenticacao de usuarios") // Adiciona grupo no Swagger
public interface LoginController {

    @PostMapping("/login")
    @Operation(
            summary = "Autenticar usuario",
            description = "Autentica um usuario e retorna um token JWT valido.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Autenticação bem-sucedida"),
                    @ApiResponse(responseCode = "401", description = "Credenciais invalidas"),
                    @ApiResponse(responseCode = "404", description = "Usuario não encontrado")
            }
    )
    ResponseEntity<String> autenticar(@RequestBody LoginRequestDTO loginRequest);
}


