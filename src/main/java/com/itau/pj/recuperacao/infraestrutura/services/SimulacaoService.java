package com.itau.pj.recuperacao.infraestrutura.services;

import com.itau.pj.recuperacao.domain.model.Simulacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SimulacaoService {
    Simulacao criarSimulacao(List<Long> dividaIds);
    Simulacao obterSimulacaoPorId(Long simulacaoId);
    Simulacao confirmarSimulacao(Long simulacaoId);
}
