package com.itau.pj.recuperacao.entrypoints.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "simulacao")
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
}



