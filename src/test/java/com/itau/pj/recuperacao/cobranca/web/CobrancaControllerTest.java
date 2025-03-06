package com.itau.pj.recuperacao.cobranca.web;

import com.itau.pj.recuperacao.domain.model.Cobranca;
import com.itau.pj.recuperacao.infraestrutura.adapters.repository.CobrancaRepository;
import com.itau.pj.recuperacao.infraestrutura.controllers.impl.CobrancaControllerImpl;
import com.itau.pj.recuperacao.infraestrutura.dto.out.CobrancaOutputDTO;
import com.itau.pj.recuperacao.infraestrutura.services.CobrancaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
