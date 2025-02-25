package com.itau.pj.recuperacao.entrypoints.repositories;

import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulacaoJpaReposity extends JpaRepository<Simulacao, Long> {
}
