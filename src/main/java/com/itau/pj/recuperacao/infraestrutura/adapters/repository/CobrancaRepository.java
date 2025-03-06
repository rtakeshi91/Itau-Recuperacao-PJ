package com.itau.pj.recuperacao.infraestrutura.adapters.repository;

import com.itau.pj.recuperacao.domain.model.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CobrancaRepository extends JpaRepository<Cobranca, Long> {
}
