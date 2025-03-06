package com.itau.pj.recuperacao.infraestrutura.services.impl;

import com.itau.pj.recuperacao.infraestrutura.services.DividaSimulacaoService;
import com.itau.pj.recuperacao.domain.model.Divida;
import com.itau.pj.recuperacao.domain.model.DividaSimulacao;
import com.itau.pj.recuperacao.domain.model.Simulacao;
import com.itau.pj.recuperacao.infraestrutura.adapters.repository.DividaRepository;
import com.itau.pj.recuperacao.infraestrutura.adapters.repository.DividaSimulacaoRepository;
import com.itau.pj.recuperacao.infraestrutura.adapters.repository.SimulacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DividaSimulacaoServiceImpl implements DividaSimulacaoService {

    @Autowired
    private DividaSimulacaoRepository dividaSimulacaoRepository;

    @Autowired
    private DividaRepository dividaRepository;

    @Autowired
    private SimulacaoRepository simulacaoRepository;

    @Override
    public DividaSimulacao criarAssociacao(Long dividaId, Long simulacaoId) {
        Divida divida = dividaRepository.findById(dividaId)
                .orElseThrow(() -> new RuntimeException("Dívida não encontrada"));
        Simulacao simulacao = simulacaoRepository.findById(simulacaoId)
                .orElseThrow(() -> new RuntimeException("Simulação não encontrada"));

        DividaSimulacao dividaSimulacao = new DividaSimulacao();
        dividaSimulacao.setDivida(divida);
        dividaSimulacao.setSimulacao(simulacao);

        return dividaSimulacaoRepository.save(dividaSimulacao);
    }

    @Override
    public List<DividaSimulacao> buscarAssociacoesPorSimulacao(Long simulacaoId) {
        return dividaSimulacaoRepository.findBySimulacaoId(simulacaoId);
    }

    @Override
    public List<DividaSimulacao> buscarAssociacoesPorDivida(Long dividaId) {
        return dividaSimulacaoRepository.findByDividaId(dividaId);
    }
}
