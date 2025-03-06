package com.itau.pj.recuperacao.cobranca.web;


import com.itau.pj.recuperacao.application.ports.in.SimulacaoUseCase;
import com.itau.pj.recuperacao.domain.model.Simulacao;
import com.itau.pj.recuperacao.infraestrutura.controllers.impl.SimulacaoControllerImpl;
import com.itau.pj.recuperacao.infraestrutura.dto.in.SimulacaoInputDTO;
import com.itau.pj.recuperacao.infraestrutura.dto.out.SimulacaoOutputDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SimulacaoControllerImplTest {

    @Mock
    private SimulacaoUseCase simulacaoUseCase;

    @InjectMocks
    private SimulacaoControllerImpl simulacaoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarSimulacao_DeveRetornarSimulacaoCriada() {
        SimulacaoInputDTO inputDTO = new SimulacaoInputDTO(Arrays.asList(1L, 2L));
        Simulacao simulacao = new Simulacao();
        simulacao.setId(1L);
        when(simulacaoUseCase.criarSimulacao(inputDTO.getDividaIds())).thenReturn(simulacao);

        ResponseEntity<SimulacaoOutputDTO> response = simulacaoController.criarSimulacao(inputDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void obterSimulacaoPorId_DeveRetornarSimulacaoCorrespondente() {
        Simulacao simulacao = new Simulacao();
        simulacao.setId(1L);
        when(simulacaoUseCase.obterSimulacaoPorId(1L)).thenReturn(simulacao);

        ResponseEntity<SimulacaoOutputDTO> response = simulacaoController.obterSimulacaoPorId(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void confirmarSimulacao_DeveRetornarSimulacaoConfirmada() {
        Simulacao simulacao = new Simulacao();
        simulacao.setId(1L);
        when(simulacaoUseCase.confirmarSimulacao(1L)).thenReturn(simulacao);

        ResponseEntity<SimulacaoOutputDTO> response = simulacaoController.confirmarSimulacao(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getId());
    }
}
