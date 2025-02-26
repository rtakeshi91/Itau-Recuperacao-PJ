package com.itau.pj.recuperacao.entrypoints.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "renegociacao")
public class Renegociacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToOne
    @JoinColumn(name = "simulacao_id", referencedColumnName = "id")
    private Simulacao simulacao;

    @Column
    private String status;
}

