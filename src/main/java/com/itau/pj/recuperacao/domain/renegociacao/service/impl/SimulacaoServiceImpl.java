package com.itau.pj.recuperacao.domain.renegociacao.service.impl;

import com.itau.pj.recuperacao.domain.renegociacao.enums.SimulacaoStatus;
import com.itau.pj.recuperacao.domain.renegociacao.service.SimulacaoService;
import com.itau.pj.recuperacao.entrypoints.entities.Divida;
import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import com.itau.pj.recuperacao.entrypoints.repositories.DividaRepository;
import com.itau.pj.recuperacao.entrypoints.repositories.SimulacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulacaoServiceImpl implements SimulacaoService {

    private final SimulacaoRepository simulacaoRepository;
    private final DividaRepository dividaRepository; // Supondo que você precise validar as dívidas antes da simulação

    public SimulacaoServiceImpl(SimulacaoRepository simulacaoRepository, DividaRepository dividaRepository) {
        this.simulacaoRepository = simulacaoRepository;
        this.dividaRepository = dividaRepository;
    }

    @Transactional
    @Override
    public Simulacao criarSimulacao(List<Long> dividaIds) {
        List<Divida> dividas = dividaRepository.findAllById(dividaIds);
        if (dividas.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma dívida válida encontrada para simulação.");
        }

        Simulacao simulacao = new Simulacao();
        simulacao.setDividas(dividas);
        simulacao.setStatus(SimulacaoStatus.PENDENTE);

        return simulacaoRepository.save(simulacao);
    }

    @Override
    public Simulacao obterSimulacaoPorId(Long simulacaoId) {
        return simulacaoRepository.findById(simulacaoId)
                .orElseThrow(() -> new RuntimeException("Simulação não encontrada"));
    }

    @Transactional
    @Override
    public Simulacao confirmarSimulacao(Long simulacaoId) {
        Simulacao simulacao = obterSimulacaoPorId(simulacaoId);
        simulacao.setStatus(SimulacaoStatus.CONFIRMADA);
        return simulacaoRepository.save(simulacao);
    }
}
