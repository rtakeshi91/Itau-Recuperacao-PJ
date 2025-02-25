package com.itau.pj.recuperacao.domain.renegociacao.service.impl;

import com.itau.pj.recuperacao.domain.renegociacao.service.RenegociacaoService;
import com.itau.pj.recuperacao.entrypoints.entities.Renegociacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenegociacaoServiceImpl implements RenegociacaoService {
    @Override
    public Renegociacao criarRenegociacao(Long simulacaoId) {
        return null;
    }

    @Override
    public List<Renegociacao> listarRenegociacoes() {
        return List.of();
    }

    @Override
    public Renegociacao obterRenegociacaoPorId(Long renegociacaoId) {
        return null;
    }
}
