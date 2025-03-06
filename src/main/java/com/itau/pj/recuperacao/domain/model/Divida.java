package com.itau.pj.recuperacao.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "divida")
@Getter
@Setter
public class Divida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Double valor;

    @ManyToMany
    @JoinTable(
            name = "divida_simulacao",
            joinColumns = @JoinColumn(name = "divida_id"),
            inverseJoinColumns = @JoinColumn(name = "simulacao_id")
    )
    private List<Simulacao> simulacoes = new ArrayList<>();  // Agora é uma lista de simulacoes

    @Column
    private Date dataVencimento;

    @Column
    private Long clienteId;
}
