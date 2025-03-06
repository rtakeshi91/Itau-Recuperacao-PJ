package com.itau.pj.recuperacao.application.ports.in;

import com.itau.pj.recuperacao.domain.model.Divida;

import java.util.List;

public interface DividaUseCase {
    List<Divida> listarDividas();
    Divida obterDividaPorId(Long dividaId);
}