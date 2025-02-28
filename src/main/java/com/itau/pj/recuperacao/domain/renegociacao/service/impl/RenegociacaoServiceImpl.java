package com.itau.pj.recuperacao.domain.renegociacao.service.impl;

import com.itau.pj.recuperacao.domain.renegociacao.enums.RenegociacaoStatus;
import com.itau.pj.recuperacao.domain.renegociacao.enums.SimulacaoStatus;
import com.itau.pj.recuperacao.domain.renegociacao.service.RenegociacaoService;
import com.itau.pj.recuperacao.entrypoints.entities.Renegociacao;
import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import com.itau.pj.recuperacao.entrypoints.repositories.RenegociacaoRepository;
import com.itau.pj.recuperacao.entrypoints.repositories.SimulacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenegociacaoServiceImpl implements RenegociacaoService {

    private final RenegociacaoRepository renegociacaoRepository;
    private final SimulacaoRepository simulacaoRepository;

    public RenegociacaoServiceImpl(RenegociacaoRepository renegociacaoRepository, SimulacaoRepository simulacaoRepository) {
        this.renegociacaoRepository = renegociacaoRepository;
        this.simulacaoRepository = simulacaoRepository;
    }

    @Transactional
    @Override
    public Renegociacao criarRenegociacao(Long simulacaoId) {
        Simulacao simulacao = simulacaoRepository.findById(simulacaoId)
                .orElseThrow(() -> new RuntimeException("Simulação não encontrada"));

        if (!simulacao.getStatus().equals(SimulacaoStatus.CONFIRMADA)) {
            throw new IllegalArgumentException("A simulação deve estar confirmada antes de gerar uma renegociação.");
        }

        Renegociacao renegociacao = new Renegociacao();
        renegociacao.setSimulacao(simulacao);
        renegociacao.setStatus(RenegociacaoStatus.ATIVA);

        return renegociacaoRepository.save(renegociacao);
    }

    @Override
    public List<Renegociacao> listarRenegociacoes() {
        return renegociacaoRepository.findAll();
    }

    @Override
    public Renegociacao obterRenegociacaoPorId(Long renegociacaoId) {
        return renegociacaoRepository.findById(renegociacaoId)
                .orElseThrow(() -> new RuntimeException("Renegociação não encontrada"));
    }
}
