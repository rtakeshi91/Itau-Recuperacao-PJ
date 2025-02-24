package com.itau.pj.recuperacao.adapters.outbound.repositories;

import com.itau.pj.recuperacao.adapters.outbound.entities.Renegociacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenegociacaoJpaReposity extends JpaRepository<Renegociacao, Long> {
}
