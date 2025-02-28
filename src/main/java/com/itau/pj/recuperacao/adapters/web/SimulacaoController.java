package com.itau.pj.recuperacao.adapters.web;

import com.itau.pj.recuperacao.domain.renegociacao.dto.input.SimulacaoInputDTO;
import com.itau.pj.recuperacao.domain.renegociacao.dto.output.SimulacaoOutputDTO;
import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Simulações", description = "API para gerenciar simulações de dívidas")
@RequestMapping("/api/simulacao")
public interface SimulacaoController {

    @Operation(summary = "Criar simulação", description = "Cria uma simulação de renegociação para as dívidas informadas")
    @ApiResponse(responseCode = "200", description = "Simulação criada com sucesso")
    @PostMapping
    ResponseEntity<SimulacaoOutputDTO> criarSimulacao(@RequestBody SimulacaoInputDTO simulacaoInputDTO);

    @Operation(summary = "Obter simulação por ID", description = "Retorna uma simulação específica pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Simulação encontrada")
    @ApiResponse(responseCode = "404", description = "Simulação não encontrada")
    @GetMapping("/{simulacao-id}")
    ResponseEntity<SimulacaoOutputDTO> obterSimulacaoPorId(
            @Parameter(description = "ID da simulação", required = true)
            @PathVariable("simulacao-id") Long simulacaoId);

    @Operation(summary = "Confirmar simulação", description = "Confirma uma simulação de renegociação")
    @ApiResponse(responseCode = "200", description = "Simulação confirmada com sucesso")
    @ApiResponse(responseCode = "404", description = "Simulação não encontrada")
    @PostMapping("/{simulacao-id}")
    ResponseEntity<SimulacaoOutputDTO> confirmarSimulacao(
            @Parameter(description = "ID da simulação", required = true)
            @PathVariable("simulacao-id") Long simulacaoId);
}
