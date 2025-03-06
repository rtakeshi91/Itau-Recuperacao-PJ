package com.itau.pj.recuperacao.infraestrutura.adapters.repository;

import com.itau.pj.recuperacao.domain.model.DividaSimulacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DividaSimulacaoRepository extends JpaRepository<DividaSimulacao, Long> {

    // Consultas personalizadas podem ser adicionadas aqui, por exemplo:

    // Encontrar todas as Dividas associadas a uma Simulacao específica
    List<DividaSimulacao> findBySimulacaoId(Long simulacaoId);

    // Encontrar todas as Simulacoes associadas a uma Divida específica
    List<DividaSimulacao> findByDividaId(Long dividaId);

    // Encontrar uma associação específica entre Divida e Simulacao
    Optional<DividaSimulacao> findByDividaIdAndSimulacaoId(Long dividaId, Long simulacaoId);
}
