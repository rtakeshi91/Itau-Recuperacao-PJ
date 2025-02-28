package com.itau.pj.recuperacao.entrypoints.entities;

import com.itau.pj.recuperacao.domain.renegociacao.enums.RenegociacaoStatus;
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
    private RenegociacaoStatus status;

    @Column
    private Long clienteId;
}

