package com.itau.pj.recuperacao.domain.renegociacao.service;

import com.itau.pj.recuperacao.entrypoints.entities.DividaSimulacao;

import java.util.List;

public interface DividaSimulacaoService {
    DividaSimulacao criarAssociacao(Long dividaId, Long simulacaoId);
    List<DividaSimulacao> buscarAssociacoesPorSimulacao(Long simulacaoId);
    List<DividaSimulacao> buscarAssociacoesPorDivida(Long dividaId);
}

