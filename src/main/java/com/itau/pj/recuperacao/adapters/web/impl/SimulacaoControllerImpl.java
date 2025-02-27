package com.itau.pj.recuperacao.adapters.web.impl;

import com.itau.pj.recuperacao.adapters.web.SimulacaoController;
import com.itau.pj.recuperacao.domain.renegociacao.model.SimulacaoUseCase;
import com.itau.pj.recuperacao.domain.renegociacao.service.SimulacaoService;
import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimulacaoControllerImpl implements SimulacaoController {

    private final SimulacaoUseCase simulacaoUseCase;

    @Autowired
    public SimulacaoControllerImpl(SimulacaoUseCase simulacaoUseCase) {
        this.simulacaoUseCase = simulacaoUseCase;
    }

    @Override
    public ResponseEntity<Simulacao> criarSimulacao(List<Long> dividaIds) {
        return ResponseEntity.ok(simulacaoUseCase.criarSimulacao(dividaIds));
    }

    @Override
    public ResponseEntity<Simulacao> obterSimulacaoPorId(Long simulacaoId) {
        return ResponseEntity.ok(simulacaoUseCase.obterSimulacaoPorId(simulacaoId));
    }

    @Override
    public ResponseEntity<Simulacao> confirmarSimulacao(Long simulacaoId) {
        return ResponseEntity.ok(simulacaoUseCase.confirmarSimulacao(simulacaoId));
    }
}

