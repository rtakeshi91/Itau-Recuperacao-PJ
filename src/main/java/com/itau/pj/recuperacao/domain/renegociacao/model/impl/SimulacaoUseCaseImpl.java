package com.itau.pj.recuperacao.domain.renegociacao.model.impl;

import com.itau.pj.recuperacao.domain.renegociacao.model.SimulacaoUseCase;
import com.itau.pj.recuperacao.domain.renegociacao.service.SimulacaoService;
import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulacaoUseCaseImpl implements SimulacaoUseCase {

    private final SimulacaoService simulacaoService;

    @Autowired
    public SimulacaoUseCaseImpl(SimulacaoService simulacaoService) {
        this.simulacaoService = simulacaoService;
    }

    @Override
    public Simulacao criarSimulacao(List<Long> dividaIds) {
        return simulacaoService.criarSimulacao(dividaIds);
    }

    @Override
    public Simulacao obterSimulacaoPorId(Long simulacaoId) {
        return simulacaoService.obterSimulacaoPorId(simulacaoId);
    }

    @Override
    public Simulacao confirmarSimulacao(Long simulacaoId) {
        return simulacaoService.confirmarSimulacao(simulacaoId);
    }
}
