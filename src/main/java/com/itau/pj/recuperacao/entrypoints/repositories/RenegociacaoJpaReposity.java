package com.itau.pj.recuperacao.entrypoints.repositories;

import com.itau.pj.recuperacao.entrypoints.entities.Renegociacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenegociacaoJpaReposity extends JpaRepository<Renegociacao, Long> {
}
