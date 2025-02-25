package com.itau.pj.recuperacao.entrypoints.repositories;

import com.itau.pj.recuperacao.entrypoints.entities.Divida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividaJpaEntity extends JpaRepository<Divida, Long> {
}
