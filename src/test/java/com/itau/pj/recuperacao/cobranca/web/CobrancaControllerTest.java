package com.itau.pj.recuperacao.cobranca.web;

import com.itau.pj.recuperacao.adapters.web.impl.CobrancaControllerImpl;
import com.itau.pj.recuperacao.domain.cobranca.dto.input.CobrancaInputDTO;
import com.itau.pj.recuperacao.domain.cobranca.dto.output.CobrancaOutputDTO;
import com.itau.pj.recuperacao.domain.cobranca.service.CobrancaService;
import com.itau.pj.recuperacao.entrypoints.entities.Cobranca;
import com.itau.pj.recuperacao.entrypoints.repositories.CobrancaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CobrancaControllerImplTest {

    @Mock
    private CobrancaService cobrancaService;

    @Mock
    private CobrancaRepository cobrancaRepository;

    @InjectMocks
    private CobrancaControllerImpl cobrancaController;

    private Cobranca cobranca;

    @BeforeEach
    void setUp() {
        cobranca = new Cobranca();
        cobranca.setId(1L);
        cobranca.setEmail("test@email.com");
        cobranca.setMensagem("Teste");
    }

    @Test
    void listarCobrancas_DeveRetornarListaDeCobrancas() {
        when(cobrancaService.listarCobrancas()).thenReturn(List.of(cobranca));

        ResponseEntity<List<CobrancaOutputDTO>> response = cobrancaController.listarCobrancas();

        assertFalse(response.getBody().isEmpty());
        assertEquals(1L, response.getBody().get(0).getId());
    }

    @Test
    void enviarCobranca_DeveChamarServico() {
        doNothing().when(cobrancaService).enviarCobranca(1L);

        ResponseEntity<Void> response = cobrancaController.enviarCobranca(1L);

        assertEquals(200, response.getStatusCodeValue());
        verify(cobrancaService, times(1)).enviarCobranca(1L);
    }
}
