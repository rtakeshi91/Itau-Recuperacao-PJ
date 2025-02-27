package com.itau.pj.recuperacao.domain.renegociacao.service.impl;

import com.itau.pj.recuperacao.domain.renegociacao.service.DividaService;
import com.itau.pj.recuperacao.entrypoints.entities.Divida;
import com.itau.pj.recuperacao.entrypoints.repositories.DividaRepository;
import com.itau.pj.recuperacao.entrypoints.repositories.SimulacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DividaServiceImpl implements DividaService {

    @Autowired
    private DividaRepository dividaRepository;

    @Override
    public List<Divida> listarDividas() {
        return dividaRepository.findAll();
    }

    @Override
    public Divida obterDividaPorId(Long dividaId) {
        return dividaRepository.findById(dividaId)
                .orElseThrow(() -> new RuntimeException("Dívida não encontrada"));
    }
}

