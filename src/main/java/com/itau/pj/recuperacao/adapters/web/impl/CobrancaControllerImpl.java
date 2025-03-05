package com.itau.pj.recuperacao.adapters.web.impl;

import com.itau.pj.recuperacao.adapters.web.CobrancaController;
import com.itau.pj.recuperacao.domain.cobranca.dto.input.CobrancaInputDTO;
import com.itau.pj.recuperacao.domain.cobranca.dto.output.CobrancaOutputDTO;
import com.itau.pj.recuperacao.domain.cobranca.service.CobrancaService;
import com.itau.pj.recuperacao.entrypoints.entities.Cobranca;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CobrancaControllerImpl implements CobrancaController {
    private final CobrancaService cobrancaService;

    @Override
    public ResponseEntity<CobrancaOutputDTO> criarCobranca(CobrancaInputDTO inputDTO) {
        Cobranca cobranca = cobrancaService.criarCobranca(inputDTO.getEmail(), inputDTO.getMensagem());

        if (cobranca == null) {
            throw new IllegalArgumentException("Cobranca não pode ser nula");
        }

        CobrancaOutputDTO outputDTO = mapCobrancaToOutputDTO(cobranca);
        return ResponseEntity.ok(outputDTO);
    }

    @Override
    public ResponseEntity<List<CobrancaOutputDTO>> listarCobrancas() {
        List<Cobranca> cobrancas = cobrancaService.listarCobrancas();
        List<CobrancaOutputDTO> cobrancaOutputDTOs = cobrancas.stream()
                .map(this::mapCobrancaToOutputDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cobrancaOutputDTOs);
    }

    @Override
    public ResponseEntity<Void> enviarCobranca(Long id) {
        cobrancaService.enviarCobranca(id);
        return ResponseEntity.ok().build();
    }

    public CobrancaOutputDTO mapCobrancaToOutputDTO(Cobranca cobranca) {
        if (cobranca == null) {
            throw new IllegalArgumentException("Cobranca não pode ser nula");
        }
        return new CobrancaOutputDTO(cobranca.getId(), cobranca.getEmail(), cobranca.getMensagem());
    }

}
