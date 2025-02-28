package com.itau.pj.recuperacao.entrypoints.repositories;

import com.itau.pj.recuperacao.entrypoints.entities.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CobrancaRepository extends JpaRepository<Cobranca, Long> {
}
