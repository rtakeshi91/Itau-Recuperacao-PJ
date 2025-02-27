package com.itau.pj.recuperacao.adapters.web.impl;

import com.itau.pj.recuperacao.adapters.web.RenegociacaoController;
import com.itau.pj.recuperacao.domain.renegociacao.model.RenegociacaoUseCase;
import com.itau.pj.recuperacao.entrypoints.entities.Divida;
import com.itau.pj.recuperacao.entrypoints.entities.Renegociacao;
import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import com.itau.pj.recuperacao.domain.renegociacao.service.DividaService;
import com.itau.pj.recuperacao.domain.renegociacao.service.RenegociacaoService;
import com.itau.pj.recuperacao.domain.renegociacao.service.SimulacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RenegociacaoControllerImpl implements RenegociacaoController {

    private final RenegociacaoUseCase renegociacaoUseCase;

    @Autowired
    public RenegociacaoControllerImpl(RenegociacaoUseCase renegociacaoUseCase) {
        this.renegociacaoUseCase = renegociacaoUseCase;
    }

    @Override
    public ResponseEntity<Renegociacao> criarRenegociacao(Long simulacaoId) {
        return ResponseEntity.ok(renegociacaoUseCase.criarRenegociacao(simulacaoId));
    }

    @Override
    public ResponseEntity<List<Renegociacao>> listarRenegociacoes() {
        return ResponseEntity.ok(renegociacaoUseCase.listarRenegociacoes());
    }

    @Override
    public ResponseEntity<Renegociacao> obterRenegociacaoPorId(Long renegociacaoId) {
        return ResponseEntity.ok(renegociacaoUseCase.obterRenegociacaoPorId(renegociacaoId));
    }
}

