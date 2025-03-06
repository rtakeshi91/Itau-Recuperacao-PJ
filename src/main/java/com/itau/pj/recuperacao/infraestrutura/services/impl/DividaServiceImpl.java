package com.itau.pj.recuperacao.infraestrutura.services.impl;

import com.itau.pj.recuperacao.infraestrutura.services.DividaService;
import com.itau.pj.recuperacao.domain.model.Divida;
import com.itau.pj.recuperacao.infraestrutura.adapters.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

