package com.itau.pj.recuperacao.domain.renegociacao.model;

import com.itau.pj.recuperacao.entrypoints.entities.Divida;

import java.util.List;

public interface DividaUseCase {
    List<Divida> listarDividas();
    Divida obterDividaPorId(Long dividaId);
}