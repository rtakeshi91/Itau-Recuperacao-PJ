package com.itau.pj.recuperacao.domain.cobranca.model;

import com.itau.pj.recuperacao.entrypoints.entities.Cobranca;

import java.util.List;

public interface CobrancaUseCase {
    Cobranca criarCobranca(String email, String mensagem);
    List<Cobranca> listarCobranca();
    void enviarCobranca(Long cobrancaId);
}
