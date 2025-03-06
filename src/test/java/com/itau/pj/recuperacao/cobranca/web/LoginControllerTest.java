package com.itau.pj.recuperacao.cobranca.web;

import com.itau.pj.recuperacao.infraestrutura.controllers.impl.LoginControllerImpl;
import com.itau.pj.recuperacao.infraestrutura.dto.in.LoginRequestDTO;
import com.itau.pj.recuperacao.infraestrutura.services.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginControllerImplTest {

    @Mock
    private LoginService loginService;

    @InjectMocks
    private LoginControllerImpl loginController;

    private LoginRequestDTO loginRequestDTO;

    @BeforeEach
    void setUp() {
        loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setLogin("user");
        loginRequestDTO.setSenha("password");
    }

    @Test
    void autenticar_DeveRetornarTokenQuandoCredenciaisSaoValidas() {
        // Arrange
        String expectedToken = "mocked-jwt-token";
        when(loginService.autenticar(loginRequestDTO)).thenReturn(expectedToken);

        // Act
        ResponseEntity<String> response = loginController.autenticar(loginRequestDTO);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedToken, response.getBody());
        verify(loginService, times(1)).autenticar(loginRequestDTO);
    }
}

