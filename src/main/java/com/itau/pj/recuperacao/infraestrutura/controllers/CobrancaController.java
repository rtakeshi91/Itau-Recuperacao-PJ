package com.itau.pj.recuperacao.infraestrutura.controllers;

import com.itau.pj.recuperacao.infraestrutura.dto.in.CobrancaInputDTO;
import com.itau.pj.recuperacao.infraestrutura.dto.out.CobrancaOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Cobrança", description = "API para gerenciamento de cobranças")
@RequestMapping("/api/cobranca")
public interface CobrancaController {

    @Operation(summary = "Criar uma nova cobrança")
    @PostMapping
    ResponseEntity<CobrancaOutputDTO> criarCobranca(@RequestBody CobrancaInputDTO cobrancaInputDTO);

    @Operation(summary = "Listar todas as cobranças")
    @GetMapping
    ResponseEntity<List<CobrancaOutputDTO>> listarCobrancas();

    @Operation(summary = "Enviar cobrança por ID")
    @PostMapping("/{id}/enviar")
    ResponseEntity<Void> enviarCobranca(@PathVariable Long id);
}
