package com.itau.pj.recuperacao.adapters.scheduler;

import com.itau.pj.recuperacao.domain.cobranca.service.CobrancaService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CobrancaScheduler {
    private final CobrancaService cobrancaService;

    @Scheduled(cron = "0 0 * * * ?") // Executa a cada hora
    public void processarCobrancas() {
        cobrancaService.listarCobrancas().forEach(cobranca ->
                cobrancaService.enviarCobranca(cobranca.getId()));
    }
}