package com.itau.pj.recuperacao.domain.renegociacao.service;

import com.itau.pj.recuperacao.adapters.outbound.entities.Divida;

import java.util.List;

public interface DividaService {
    List<Divida> listarDividas();
    Divida obterDividaPorId(Long dividaId);
}
