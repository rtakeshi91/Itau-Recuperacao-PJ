package com.itau.pj.recuperacao.cobranca.web;

import com.itau.pj.recuperacao.application.ports.in.DividaUseCase;
import com.itau.pj.recuperacao.domain.model.Divida;
import com.itau.pj.recuperacao.infraestrutura.controllers.impl.DividaControllerImpl;
import com.itau.pj.recuperacao.infraestrutura.dto.out.DividaOutputDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DividaControllerImplTest {

    @Mock
    private DividaUseCase dividaUseCase;

    @InjectMocks
    private DividaControllerImpl dividaController;

    private Divida divida;

    @BeforeEach
    void setUp() {
        divida = new Divida();
        divida.setId(1L);
    }

    @Test
    void listarDividas_DeveRetornarListaDeDividas() {
        when(dividaUseCase.listarDividas()).thenReturn(List.of(divida));

        ResponseEntity<List<DividaOutputDTO>> response = dividaController.listarDividas();

        assertFalse(response.getBody().isEmpty());
        assertEquals(1L, response.getBody().get(0).getId());
    }

    @Test
    void obterDividaPorId_DeveRetornarDivida() {
        when(dividaUseCase.obterDividaPorId(1L)).thenReturn(divida);

        ResponseEntity<DividaOutputDTO> response = dividaController.obterDividaPorId(1L);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
    }
}

