package com.itau.pj.recuperacao.domain.renegociacao.model;

import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;

import java.util.List;

public interface SimulacaoUseCase {
    Simulacao criarSimulacao(List<Long> dividaIds);
    Simulacao obterSimulacaoPorId(Long simulacaoId);
    Simulacao confirmarSimulacao(Long simulacaoId);
}