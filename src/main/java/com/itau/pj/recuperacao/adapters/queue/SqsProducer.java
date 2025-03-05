package com.itau.pj.recuperacao.adapters.queue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

@Component
@RequiredArgsConstructor
@Slf4j
public class SqsProducer {

    private final SqsClient sqsClient;

    @Value("${aws.sqs.queue-url}")
    private String queueUrl;

    public void sendMessage(String messageBody) {
        // Criando a requisição para enviar a mensagem
        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(messageBody)  // Corpo da mensagem
                .build();

        // Enviando a mensagem e obtendo a resposta
        SendMessageResponse response = sqsClient.sendMessage(sendMessageRequest);
        log.info("Mensagem enviada para SQS com ID: {}", response.messageId());
    }
}


