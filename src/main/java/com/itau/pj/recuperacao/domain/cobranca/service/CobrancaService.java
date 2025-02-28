package com.itau.pj.recuperacao.domain.cobranca.service;

import com.itau.pj.recuperacao.entrypoints.entities.Cobranca;
import java.util.List;

public interface CobrancaService {
    Cobranca criarCobranca(String email, String mensagem);
    List<Cobranca> listarCobrancas();
    void enviarCobranca(Long cobrancaId);
}
