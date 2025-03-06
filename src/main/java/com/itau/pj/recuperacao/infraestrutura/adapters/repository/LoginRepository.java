package com.itau.pj.recuperacao.infraestrutura.adapters.repository;

import com.itau.pj.recuperacao.domain.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByLogin(String login);
}