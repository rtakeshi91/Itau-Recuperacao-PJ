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
@RequestMapping("/api/renegociacao")
public interface RenegociacaoController {

    @Operation(summary = "Criar renegociação", description = "Cria uma renegociação a partir de uma simulação confirmada")
    @ApiResponse(responseCode = "200", description = "Renegociação criada com sucesso")
    @ApiResponse(responseCode = "404", description = "Simulação não encontrada")
    @PostMapping
    ResponseEntity<Renegociacao> criarRenegociacao(
            @Parameter(description = "ID da simulação confirmada", required = true)
            @RequestBody Long simulacaoId);

    @Operation(summary = "Listar renegociações", description = "Retorna uma lista de todas as renegociações")
    @ApiResponse(responseCode = "200", description = "Renegociações listadas com sucesso")
    @GetMapping
    ResponseEntity<List<Renegociacao>> listarRenegociacoes();

    @Operation(summary = "Obter renegociação por ID", description = "Retorna uma renegociação específica pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Renegociação encontrada")
    @ApiResponse(responseCode = "404", description = "Renegociação não encontrada")
    @GetMapping("/{renegociacao-id}")
    ResponseEntity<Renegociacao> obterRenegociacaoPorId(
            @Parameter(description = "ID da renegociação", required = true)
            @PathVariable("renegociacao-id") Long renegociacaoId);
}
