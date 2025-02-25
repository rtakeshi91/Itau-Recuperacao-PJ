package com.itau.pj.recuperacao.domain.renegociacao.service.impl;

import com.itau.pj.recuperacao.domain.renegociacao.service.DividaService;
import com.itau.pj.recuperacao.entrypoints.entities.Divida;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DividaServiceImpl implements DividaService {

    @Override
    public List<Divida> listarDividas() {
        return List.of();
    }

    @Override
    public Divida obterDividaPorId(Long dividaId) {
        return null;
    }
}
