package com.itau.pj.recuperacao.domain.renegociacao.service;

import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SimulacaoService {
    Simulacao criarSimulacao(List<Long> dividaIds);
    Simulacao obterSimulacaoPorId(Long simulacaoId);
    Simulacao confirmarSimulacao(Long simulacaoId);
}
