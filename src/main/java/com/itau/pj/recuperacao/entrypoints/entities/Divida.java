package com.itau.pj.recuperacao.entrypoints.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "divida")
public class Divida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "simulacao_id") // Chave estrangeira para Simulacao
    private Simulacao simulacao;
}

