package com.itau.pj.recuperacao.infraestrutura.services;

import com.itau.pj.recuperacao.domain.model.Renegociacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RenegociacaoService {
    Renegociacao criarRenegociacao(Long simulacaoId);
    List<Renegociacao> listarRenegociacoes();
    Renegociacao obterRenegociacaoPorId(Long renegociacaoId);
}
