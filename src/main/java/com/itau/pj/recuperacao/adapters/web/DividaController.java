package com.itau.pj.recuperacao.adapters.web;

import com.itau.pj.recuperacao.domain.renegociacao.dto.output.DividaOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Dividas", description = "API para gerenciar dívidas")
@RequestMapping("/api/dividas")
public interface DividaController {

    @Operation(summary = "Listar dívidas", description = "Retorna uma lista de todas as dívidas")
    @ApiResponse(responseCode = "200", description = "Dívidas listadas com sucesso")
    @GetMapping
    ResponseEntity<List<DividaOutputDTO>> listarDividas();

    @Operation(summary = "Obter dívida por ID", description = "Retorna uma dívida específica pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Dívida encontrada")
    @ApiResponse(responseCode = "404", description = "Dívida não encontrada")
    @GetMapping("/{divida-id}")
    ResponseEntity<DividaOutputDTO> obterDividaPorId(
            @Parameter(description = "ID da dívida", required = true)
            @PathVariable("divida-id") Long dividaId);
}

