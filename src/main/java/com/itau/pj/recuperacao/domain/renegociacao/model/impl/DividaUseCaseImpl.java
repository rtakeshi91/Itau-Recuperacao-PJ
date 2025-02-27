package com.itau.pj.recuperacao.domain.renegociacao.model.impl;

import com.itau.pj.recuperacao.domain.renegociacao.model.DividaUseCase;
import com.itau.pj.recuperacao.domain.renegociacao.service.DividaService;
import com.itau.pj.recuperacao.entrypoints.entities.Divida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DividaUseCaseImpl implements DividaUseCase {

    private final DividaService dividaService;

    @Autowired
    public DividaUseCaseImpl(DividaService dividaService) {
        this.dividaService = dividaService;
    }

    @Override
    public List<Divida> listarDividas() {
        return dividaService.listarDividas();
    }

    @Override
    public Divida obterDividaPorId(Long dividaId) {
        return dividaService.obterDividaPorId(dividaId);
    }
}
