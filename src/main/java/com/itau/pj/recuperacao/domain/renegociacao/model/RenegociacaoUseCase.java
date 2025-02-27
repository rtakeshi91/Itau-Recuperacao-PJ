package com.itau.pj.recuperacao.domain.renegociacao.model;

import com.itau.pj.recuperacao.entrypoints.entities.Renegociacao;

import java.util.List;

public interface RenegociacaoUseCase {
    Renegociacao criarRenegociacao(Long simulacaoId);
    List<Renegociacao> listarRenegociacoes();
    Renegociacao obterRenegociacaoPorId(Long renegociacaoId);
}
