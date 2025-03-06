package com.itau.pj.recuperacao.application.ports.in;

import com.itau.pj.recuperacao.domain.model.Cobranca;

import java.util.List;

public interface CobrancaUseCase {
    Cobranca criarCobranca(String email, String mensagem);
    List<Cobranca> listarCobranca();
    void enviarCobranca(Long cobrancaId);
}
