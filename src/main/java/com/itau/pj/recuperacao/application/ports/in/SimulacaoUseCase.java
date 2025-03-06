package com.itau.pj.recuperacao.application.ports.in;

import com.itau.pj.recuperacao.domain.model.Simulacao;

import java.util.List;

public interface SimulacaoUseCase {
    Simulacao criarSimulacao(List<Long> dividaIds);
    Simulacao obterSimulacaoPorId(Long simulacaoId);
    Simulacao confirmarSimulacao(Long simulacaoId);
}