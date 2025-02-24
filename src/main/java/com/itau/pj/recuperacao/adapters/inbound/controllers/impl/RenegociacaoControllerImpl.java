package com.itau.pj.recuperacao.adapters.inbound.controllers.impl;

import com.itau.pj.recuperacao.adapters.inbound.controllers.RenegociacaoController;

import com.itau.pj.recuperacao.adapters.outbound.entities.Divida;
import com.itau.pj.recuperacao.adapters.outbound.entities.Renegociacao;
import com.itau.pj.recuperacao.adapters.outbound.entities.Simulacao;
import com.itau.pj.recuperacao.domain.renegociacao.service.DividaService;
import com.itau.pj.recuperacao.domain.renegociacao.service.RenegociacaoService;
import com.itau.pj.recuperacao.domain.renegociacao.service.SimulacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RenegociacaoControllerImpl implements RenegociacaoController {

    @Autowired
    private DividaService dividaService;

    @Autowired
    private SimulacaoService simulacaoService;

    @Autowired
    private RenegociacaoService renegociacaoService;

    @Override
    public ResponseEntity<List<Divida>> listarDividas() {
        List<Divida> dividas = dividaService.listarDividas();
        return ResponseEntity.ok(dividas);
    }

    @Override
    public ResponseEntity<Divida> obterDividaPorId(Long dividaId) {
        Divida divida = dividaService.obterDividaPorId(dividaId);
        return ResponseEntity.ok(divida);
    }

    @Override
    public ResponseEntity<Simulacao> criarSimulacao(List<Long> dividaIds) {
        Simulacao simulacao = simulacaoService.criarSimulacao(dividaIds);
        return ResponseEntity.ok(simulacao);
    }

    @Override
    public ResponseEntity<Simulacao> obterSimulacaoPorId(Long simulacaoId) {
        Simulacao simulacao = simulacaoService.obterSimulacaoPorId(simulacaoId);
        return ResponseEntity.ok(simulacao);
    }

    @Override
    public ResponseEntity<Simulacao> confirmarSimulacao(Long simulacaoId) {
        Simulacao simulacao = simulacaoService.confirmarSimulacao(simulacaoId);
        return ResponseEntity.ok(simulacao);
    }

    @Override
    public ResponseEntity<Renegociacao> criarRenegociacao(Long simulacaoId) {
        Renegociacao renegociacao = renegociacaoService.criarRenegociacao(simulacaoId);
        return ResponseEntity.ok(renegociacao);
    }

    @Override
    public ResponseEntity<List<Renegociacao>> listarRenegociacoes() {
        List<Renegociacao> renegociacoes = renegociacaoService.listarRenegociacoes();
        return ResponseEntity.ok(renegociacoes);
    }

    @Override
    public ResponseEntity<Renegociacao> obterRenegociacaoPorId(Long renegociacaoId) {
        Renegociacao renegociacao = renegociacaoService.obterRenegociacaoPorId(renegociacaoId);
        return ResponseEntity.ok(renegociacao);
    }
}
