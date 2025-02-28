package com.itau.pj.recuperacao.domain.cobranca.service.impl;

import com.itau.pj.recuperacao.domain.cobranca.model.CobrancaUseCase;
import com.itau.pj.recuperacao.domain.cobranca.service.CobrancaService;
import com.itau.pj.recuperacao.entrypoints.entities.Cobranca;
import com.itau.pj.recuperacao.entrypoints.repositories.CobrancaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CobrancaServiceImpl implements CobrancaService {
    private final CobrancaRepository cobrancaRepository;
    private final CobrancaUseCase cobrancaUseCase;

    @Override
    public Cobranca criarCobranca(String email, String mensagem) {
        return cobrancaUseCase.criarCobranca(email, mensagem);
    }

    @Override
    public List<Cobranca> listarCobrancas() {
        return cobrancaUseCase.listarCobranca();
    }

    @Override
    public void enviarCobranca(Long cobrancaId) {
        cobrancaUseCase.enviarCobranca(cobrancaId);
    }
}
