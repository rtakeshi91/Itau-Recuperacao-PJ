package com.itau.pj.recuperacao.domain.renegociacao.service;

import com.itau.pj.recuperacao.entrypoints.entities.Divida;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DividaService {
    List<Divida> listarDividas();
    Divida obterDividaPorId(Long dividaId);
}
