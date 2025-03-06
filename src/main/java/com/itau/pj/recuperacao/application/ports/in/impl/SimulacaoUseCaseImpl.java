package com.itau.pj.recuperacao.application.ports.in.impl;

import com.itau.pj.recuperacao.application.ports.in.SimulacaoUseCase;
import com.itau.pj.recuperacao.infraestrutura.services.SimulacaoService;
import com.itau.pj.recuperacao.domain.model.Simulacao;
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
