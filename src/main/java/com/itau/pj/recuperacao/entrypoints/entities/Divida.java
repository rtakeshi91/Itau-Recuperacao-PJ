package com.itau.pj.recuperacao.entrypoints.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "divida")
public class Divida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "simulacao_id") // Chave estrangeira para Simulacao
    private Simulacao simulacao;

    @Column
    Date dataVencimento;
}

