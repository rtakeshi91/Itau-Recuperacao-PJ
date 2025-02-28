package com.itau.pj.recuperacao.entrypoints.repositories;

import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SimulacaoRepository extends JpaRepository<Simulacao, Long> {
    Optional<Simulacao> findById(Long id);
}