package com.itau.pj.recuperacao.infraestrutura.services;

import com.itau.pj.recuperacao.domain.model.Divida;

import java.util.List;

public interface DividaService {
    List<Divida> listarDividas();
    Divida obterDividaPorId(Long dividaId);
}

