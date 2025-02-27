package com.itau.pj.recuperacao.entrypoints.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "divida_simulacao")
public class DividaSimulacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "divida_id")
    private Divida divida;

    @ManyToOne
    @JoinColumn(name = "simulacao_id")
    private Simulacao simulacao;

    // Outros campos, se necessário (por exemplo, data de associação, status, etc.)
}
