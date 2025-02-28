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
    public ResponseEntity<CobrancaOutputDTO> criarCobranca(CobrancaInputDTO cobrancaInputDTO) {
        Cobranca cobranca = cobrancaService.criarCobranca(cobrancaInputDTO.getEmail(), cobrancaInputDTO.getMensagem());
        CobrancaOutputDTO cobrancaOutputDTO = mapCobrancaToOutputDTO(cobranca); // Método para mapear
        return ResponseEntity.ok(cobrancaOutputDTO);
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

    private CobrancaOutputDTO mapCobrancaToOutputDTO(Cobranca cobranca) {
        // Implemente a lógica de mapeamento aqui
        CobrancaOutputDTO dto = new CobrancaOutputDTO();
        dto.setId(cobranca.getId());
        dto.setEmail(cobranca.getEmail());
        dto.setMensagem(cobranca.getMensagem());
        // Mapear outros campos
        return dto;
    }
}

// Implementações das outras controllers seguem o mesmo padrão, utilizando os DTOs correspondentes e métodos de mapeamento.

