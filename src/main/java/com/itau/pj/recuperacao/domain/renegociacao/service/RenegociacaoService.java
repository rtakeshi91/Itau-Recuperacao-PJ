package com.itau.pj.recuperacao.domain.renegociacao.service;

import com.itau.pj.recuperacao.adapters.outbound.entities.Renegociacao;

import java.util.List;

public interface RenegociacaoService {
    Renegociacao criarRenegociacao(Long simulacaoId);
    List<Renegociacao> listarRenegociacoes();
    Renegociacao obterRenegociacaoPorId(Long renegociacaoId);
}
