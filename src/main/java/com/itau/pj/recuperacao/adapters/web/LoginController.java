package com.itau.pj.recuperacao.adapters.web;

import com.itau.pj.recuperacao.domain.autenticacao.dto.input.LoginRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "Autenticação", description = "Endpoints para autenticação de usuários") // Adiciona grupo no Swagger
public interface LoginController {

    @PostMapping("/login")
    @Operation(
            summary = "Autenticar usuário",
            description = "Autentica um usuário e retorna um token JWT válido.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Autenticação bem-sucedida"),
                    @ApiResponse(responseCode = "401", description = "Credenciais inválidas"),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            }
    )
    ResponseEntity<String> autenticar(@RequestBody LoginRequestDTO loginRequest);
}

