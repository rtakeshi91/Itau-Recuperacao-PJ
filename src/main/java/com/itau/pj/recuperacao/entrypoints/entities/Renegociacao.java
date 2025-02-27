package com.itau.pj.recuperacao.entrypoints.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "renegociacao")
@Getter
@Setter
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

    @Column
    private Long clienteId;
}

