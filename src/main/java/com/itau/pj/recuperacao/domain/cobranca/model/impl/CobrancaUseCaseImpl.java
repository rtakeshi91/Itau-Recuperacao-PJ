package com.itau.pj.recuperacao.domain.cobranca.model.impl;

import com.itau.pj.recuperacao.domain.cobranca.model.CobrancaUseCase;
import com.itau.pj.recuperacao.entrypoints.entities.Cobranca;
import com.itau.pj.recuperacao.entrypoints.repositories.CobrancaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CobrancaUseCaseImpl implements CobrancaUseCase {
    private final CobrancaRepository cobrancaRepository;

    @Override
    public Cobranca criarCobranca(String email, String mensagem) {
        Cobranca cobranca = Cobranca.builder()
                .email(email)
                .mensagem(mensagem)
                .dataEnvio(null)
                .build();
        return cobrancaRepository.save(cobranca);
    }

    @Override
    public List<Cobranca> listarCobranca() {
        return cobrancaRepository.findAll();
    }

    @Override
    public void enviarCobranca(Long cobrancaId) {
        Cobranca cobranca = cobrancaRepository.findById(cobrancaId)
                .orElseThrow(() -> new RuntimeException("Cobrança não encontrada"));
        cobranca.setDataEnvio(LocalDateTime.now());
        cobrancaRepository.save(cobranca);
    }
}