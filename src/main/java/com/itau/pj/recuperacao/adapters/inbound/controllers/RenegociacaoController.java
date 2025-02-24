package com.itau.pj.recuperacao.adapters.inbound.controllers;

import com.itau.pj.recuperacao.adapters.outbound.entities.Divida;
import com.itau.pj.recuperacao.adapters.outbound.entities.Renegociacao;
import com.itau.pj.recuperacao.adapters.outbound.entities.Simulacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
public interface RenegociacaoController {

    @GetMapping("/dividas")
    ResponseEntity<List<Divida>> listarDividas();

    @GetMapping("/dividas/{divida-id}")
    ResponseEntity<Divida> obterDividaPorId(@PathVariable("divida-id") Long dividaId);

    @PostMapping("/simulacao")
    ResponseEntity<Simulacao> criarSimulacao(@RequestBody List<Long> dividaIds);

    @GetMapping("/simulacao/{simulacao-id}")
    ResponseEntity<Simulacao> obterSimulacaoPorId(@PathVariable("simulacao-id") Long simulacaoId);

    @PostMapping("/simulacao/{simulacao-id}")
    ResponseEntity<Simulacao> confirmarSimulacao(@PathVariable("simulacao-id") Long simulacaoId);

    @PostMapping("/renegociacao")
    ResponseEntity<Renegociacao> criarRenegociacao(@RequestBody Long simulacaoId);

    @GetMapping("/renegociacao")
    ResponseEntity<List<Renegociacao>> listarRenegociacoes();

    @GetMapping("/renegociacao/{renegociacao-id}")
    ResponseEntity<Renegociacao> obterRenegociacaoPorId(@PathVariable("renegociacao-id") Long renegociacaoId);
}
