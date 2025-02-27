package com.itau.pj.recuperacao.adapters.web.impl;

import com.itau.pj.recuperacao.adapters.web.DividaController;
import com.itau.pj.recuperacao.domain.renegociacao.model.DividaUseCase;
import com.itau.pj.recuperacao.domain.renegociacao.service.DividaService;
import com.itau.pj.recuperacao.entrypoints.entities.Divida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DividaControllerImpl implements DividaController {

    private final DividaUseCase dividaUseCase;

    @Autowired
    public DividaControllerImpl(DividaUseCase dividaUseCase) {
        this.dividaUseCase = dividaUseCase;
    }

    @Override
    public ResponseEntity<List<Divida>> listarDividas() {
        return ResponseEntity.ok(dividaUseCase.listarDividas());
    }

    @Override
    public ResponseEntity<Divida> obterDividaPorId(Long dividaId) {
        return ResponseEntity.ok(dividaUseCase.obterDividaPorId(dividaId));
    }
}

