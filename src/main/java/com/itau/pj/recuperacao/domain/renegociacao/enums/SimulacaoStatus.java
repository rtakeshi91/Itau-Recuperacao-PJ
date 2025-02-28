package com.itau.pj.recuperacao.domain.renegociacao.enums;

public enum SimulacaoStatus {
    PENDENTE,    // Simulação criada, mas ainda não confirmada
    CONFIRMADA,  // Simulação confirmada e pronta para gerar uma renegociação
    CANCELADA    // Simulação cancelada antes da confirmação
}
