package com.itau.pj.recuperacao.domain.renegociacao.service;

import com.itau.pj.recuperacao.entrypoints.entities.Renegociacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RenegociacaoService {
    Renegociacao criarRenegociacao(Long simulacaoId);
    List<Renegociacao> listarRenegociacoes();
    Renegociacao obterRenegociacaoPorId(Long renegociacaoId);
}
