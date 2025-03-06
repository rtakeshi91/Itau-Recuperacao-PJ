package com.itau.pj.recuperacao.infraestrutura.adapters.repository;

import com.itau.pj.recuperacao.domain.model.Divida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividaRepository extends JpaRepository<Divida, Long> {
}
