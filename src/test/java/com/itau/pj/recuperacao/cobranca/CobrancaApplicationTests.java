package com.itau.pj.recuperacao.cobranca;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import software.amazon.awssdk.services.sqs.SqsClient;

@ActiveProfiles("test")
@SpringBootTest
class CobrancaApplicationTests {

	@Autowired
	private SqsClient sqsClient;

	@Test
	void contextLoads() {

	}
}
