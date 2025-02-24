package com.itau.pj.recuperacao.adapters.outbound.repositories;

import com.itau.pj.recuperacao.adapters.outbound.entities.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulacaoJpaReposity extends JpaRepository<Simulacao, Long> {
}
