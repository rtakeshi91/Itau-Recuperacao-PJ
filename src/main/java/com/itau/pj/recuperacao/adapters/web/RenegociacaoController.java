package com.itau.pj.recuperacao.adapters.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.itau.pj.recuperacao.entrypoints.entities.Divida;
import com.itau.pj.recuperacao.entrypoints.entities.Renegociacao;
import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Renegociação", description = "API para gerenciar renegociações de dívidas")
@RequestMapping("/api")
public interface RenegociacaoController {

    @Operation(summary = "Listar dívidas", description = "Retorna uma lista de todas as dívidas")
    @ApiResponse(responseCode = "200", description = "Dívidas listadas com sucesso")
    @GetMapping("/dividas")
    ResponseEntity<List<Divida>> listarDividas();

    @Operation(summary = "Obter dívida por ID", description = "Retorna uma dívida específica pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Dívida encontrada")
    @ApiResponse(responseCode = "404", description = "Dívida não encontrada")
    @GetMapping("/dividas/{divida-id}")
    ResponseEntity<Divida> obterDividaPorId(
            @Parameter(description = "ID da dívida", required = true)
            @PathVariable("divida-id") Long dividaId);

    @Operation(summary = "Criar simulação", description = "Cria uma simulação de renegociação para as dívidas informadas")
    @ApiResponse(responseCode = "200", description = "Simulação criada com sucesso")
    @PostMapping("/simulacao")
    ResponseEntity<Simulacao> criarSimulacao(
            @Parameter(description = "IDs das dívidas", required = true)
            @RequestBody List<Long> dividaIds);

    @Operation(summary = "Obter simulação por ID", description = "Retorna uma simulação específica pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Simulação encontrada")
    @ApiResponse(responseCode = "404", description = "Simulação não encontrada")
    @GetMapping("/simulacao/{simulacao-id}")
    ResponseEntity<Simulacao> obterSimulacaoPorId(
            @Parameter(description = "ID da simulação", required = true)
            @PathVariable("simulacao-id") Long simulacaoId);

    @Operation(summary = "Confirmar simulação", description = "Confirma uma simulação de renegociação")
    @ApiResponse(responseCode = "200", description = "Simulação confirmada com sucesso")
    @ApiResponse(responseCode = "404", description = "Simulação não encontrada")
    @PostMapping("/simulacao/{simulacao-id}")
    ResponseEntity<Simulacao> confirmarSimulacao(
            @Parameter(description = "ID da simulação", required = true)
            @PathVariable("simulacao-id") Long simulacaoId);

    @Operation(summary = "Criar renegociação", description = "Cria uma renegociação a partir de uma simulação confirmada")
    @ApiResponse(responseCode = "200", description = "Renegociação criada com sucesso")
    @ApiResponse(responseCode = "404", description = "Simulação não encontrada")
    @PostMapping("/renegociacao")
    ResponseEntity<Renegociacao> criarRenegociacao(
            @Parameter(description = "ID da simulação confirmada", required = true)
            @RequestBody Long simulacaoId);

    @Operation(summary = "Listar renegociações", description = "Retorna uma lista de todas as renegociações")
    @ApiResponse(responseCode = "200", description = "Renegociações listadas com sucesso")
    @GetMapping("/renegociacao")
    ResponseEntity<List<Renegociacao>> listarRenegociacoes();

    @Operation(summary = "Obter renegociação por ID", description = "Retorna uma renegociação específica pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Renegociação encontrada")
    @ApiResponse(responseCode = "404", description = "Renegociação não encontrada")
    @GetMapping("/renegociacao/{renegociacao-id}")
    ResponseEntity<Renegociacao> obterRenegociacaoPorId(
            @Parameter(description = "ID da renegociação", required = true)
            @PathVariable("renegociacao-id") Long renegociacaoId);
}
