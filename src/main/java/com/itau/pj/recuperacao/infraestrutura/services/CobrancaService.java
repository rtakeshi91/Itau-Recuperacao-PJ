package com.itau.pj.recuperacao.infraestrutura.services;

import com.itau.pj.recuperacao.domain.model.Cobranca;
import java.util.List;

public interface CobrancaService {
    Cobranca criarCobranca(String email, String mensagem);
    List<Cobranca> listarCobrancas();
    void enviarCobranca(Long cobrancaId);
}
