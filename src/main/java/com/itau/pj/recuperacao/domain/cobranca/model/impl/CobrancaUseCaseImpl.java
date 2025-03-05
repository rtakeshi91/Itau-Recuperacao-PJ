package com.itau.pj.recuperacao.domain.cobranca.model.impl;

import com.itau.pj.recuperacao.domain.cobranca.model.CobrancaUseCase;
import com.itau.pj.recuperacao.entrypoints.entities.Cobranca;
import com.itau.pj.recuperacao.entrypoints.repositories.CobrancaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import com.itau.pj.recuperacao.adapters.queue.SqsProducer;

@Service
@RequiredArgsConstructor
public class CobrancaUseCaseImpl implements CobrancaUseCase {
    private final CobrancaRepository cobrancaRepository;
    private final SqsProducer sqsProducer;

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

        // Enviando a mensagem para a fila do SQS
        String mensagem = "Cobrança ID: " + cobranca.getId() + " | Email: " + cobranca.getEmail();
        sqsProducer.sendMessage(mensagem); // Chama o método para enviar a mensagem para o SQS

        // Atualizando a cobrança com a data de envio
        cobranca.setDataEnvio(LocalDateTime.now());
        cobrancaRepository.save(cobranca);
    }
}
