package com.itau.pj.recuperacao.infraestrutura.services;

import com.itau.pj.recuperacao.domain.model.DividaSimulacao;

import java.util.List;

public interface DividaSimulacaoService {
    DividaSimulacao criarAssociacao(Long dividaId, Long simulacaoId);
    List<DividaSimulacao> buscarAssociacoesPorSimulacao(Long simulacaoId);
    List<DividaSimulacao> buscarAssociacoesPorDivida(Long dividaId);
}

