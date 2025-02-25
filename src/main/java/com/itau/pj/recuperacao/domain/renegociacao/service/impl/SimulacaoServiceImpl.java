package com.itau.pj.recuperacao.domain.renegociacao.service.impl;

import com.itau.pj.recuperacao.domain.renegociacao.service.SimulacaoService;
import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulacaoServiceImpl implements SimulacaoService {
    @Override
    public Simulacao criarSimulacao(List<Long> dividaIds) {
        return null;
    }

    @Override
    public Simulacao obterSimulacaoPorId(Long simulacaoId) {
        return null;
    }

    @Override
    public Simulacao confirmarSimulacao(Long simulacaoId) {
        return null;
    }
}
