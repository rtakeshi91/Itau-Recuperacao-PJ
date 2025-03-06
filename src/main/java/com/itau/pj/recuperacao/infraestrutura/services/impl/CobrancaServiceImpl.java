package com.itau.pj.recuperacao.infraestrutura.services.impl;

import com.itau.pj.recuperacao.application.ports.in.CobrancaUseCase;
import com.itau.pj.recuperacao.infraestrutura.services.CobrancaService;
import com.itau.pj.recuperacao.domain.model.Cobranca;
import com.itau.pj.recuperacao.infraestrutura.adapters.repository.CobrancaRepository;
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
