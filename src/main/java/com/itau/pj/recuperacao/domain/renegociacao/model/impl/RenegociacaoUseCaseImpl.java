package com.itau.pj.recuperacao.domain.renegociacao.model.impl;

import com.itau.pj.recuperacao.domain.renegociacao.model.RenegociacaoUseCase;
import com.itau.pj.recuperacao.domain.renegociacao.service.RenegociacaoService;
import com.itau.pj.recuperacao.entrypoints.entities.Renegociacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenegociacaoUseCaseImpl implements RenegociacaoUseCase {

    private final RenegociacaoService renegociacaoService;

    @Autowired
    public RenegociacaoUseCaseImpl(RenegociacaoService renegociacaoService) {
        this.renegociacaoService = renegociacaoService;
    }

    @Override
    public Renegociacao criarRenegociacao(Long simulacaoId) {
        return renegociacaoService.criarRenegociacao(simulacaoId);
    }

    @Override
    public List<Renegociacao> listarRenegociacoes() {
        return renegociacaoService.listarRenegociacoes();
    }

    @Override
    public Renegociacao obterRenegociacaoPorId(Long renegociacaoId) {
        return renegociacaoService.obterRenegociacaoPorId(renegociacaoId);
    }
}

