package com.itau.pj.recuperacao.adapters.outbound.repositories;

import com.itau.pj.recuperacao.adapters.outbound.entities.Divida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividaJpaEntity extends JpaRepository<Divida, Long> {
}
