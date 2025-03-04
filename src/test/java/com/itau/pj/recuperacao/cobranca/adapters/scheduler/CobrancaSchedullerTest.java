package com.itau.pj.recuperacao.cobranca.adapters.scheduler;

import com.itau.pj.recuperacao.adapters.scheduler.CobrancaScheduler;
import com.itau.pj.recuperacao.domain.cobranca.service.CobrancaService;
import com.itau.pj.recuperacao.entrypoints.entities.Cobranca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CobrancaSchedulerTest {

    @Mock
    private CobrancaService cobrancaService;

    @InjectMocks
    private CobrancaScheduler cobrancaScheduler;

    @BeforeEach
    void setUp() {
        when(cobrancaService.listarCobrancas()).thenReturn(List.of());
    }

    @Test
    void processarCobrancas_DeveChamarServicoParaCadaCobranca() {
        var cobranca = mock(Cobranca.class);
        when(cobranca.getId()).thenReturn(1L);
        when(cobrancaService.listarCobrancas()).thenReturn(List.of(cobranca));

        cobrancaScheduler.processarCobrancas();

        verify(cobrancaService, times(1)).enviarCobranca(1L);
    }
}
