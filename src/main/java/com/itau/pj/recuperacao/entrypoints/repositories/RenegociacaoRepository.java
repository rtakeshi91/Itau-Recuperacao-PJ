package com.itau.pj.recuperacao.entrypoints.repositories;

import com.itau.pj.recuperacao.entrypoints.entities.Renegociacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenegociacaoRepository extends JpaRepository<Renegociacao, Long> {
}