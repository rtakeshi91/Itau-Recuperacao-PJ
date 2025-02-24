package com.itau.pj.recuperacao.domain.renegociacao.service;

import com.itau.pj.recuperacao.adapters.outbound.entities.Simulacao;

import java.util.List;

public interface SimulacaoService {
    Simulacao criarSimulacao(List<Long> dividaIds);
    Simulacao obterSimulacaoPorId(Long simulacaoId);
    Simulacao confirmarSimulacao(Long simulacaoId);
}
