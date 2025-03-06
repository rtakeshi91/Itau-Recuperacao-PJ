package com.itau.pj.recuperacao.application.ports.in;

import com.itau.pj.recuperacao.infraestrutura.dto.in.LoginRequestDTO;
import com.itau.pj.recuperacao.domain.model.Renegociacao;

import java.util.List;

public interface RenegociacaoUseCase {
    Renegociacao criarRenegociacao(Long simulacaoId);
    List<Renegociacao> listarRenegociacoes();
    Renegociacao obterRenegociacaoPorId(Long renegociacaoId);

    interface LoginUseCase {
        String executar(LoginRequestDTO loginRequest);
    }
}
