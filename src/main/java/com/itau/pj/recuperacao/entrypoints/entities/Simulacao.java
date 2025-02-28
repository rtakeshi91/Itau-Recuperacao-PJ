package com.itau.pj.recuperacao.entrypoints.entities;

import com.itau.pj.recuperacao.domain.renegociacao.enums.SimulacaoStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "simulacao")
@Getter
@Setter
public class Simulacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToMany(mappedBy = "simulacoes")  // Relacionamento bidirecional
    private List<Divida> dividas = new ArrayList<>();

    @Column
    private Long clienteId;

    @Column
    private Double valorTotal;

    @Column
    private SimulacaoStatus status;
}



