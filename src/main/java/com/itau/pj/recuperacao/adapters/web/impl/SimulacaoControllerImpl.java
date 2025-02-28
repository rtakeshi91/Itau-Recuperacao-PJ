package com.itau.pj.recuperacao.adapters.web.impl;

import com.itau.pj.recuperacao.adapters.web.SimulacaoController;
import com.itau.pj.recuperacao.domain.renegociacao.dto.input.SimulacaoInputDTO;
import com.itau.pj.recuperacao.domain.renegociacao.dto.output.SimulacaoOutputDTO;
import com.itau.pj.recuperacao.domain.renegociacao.model.SimulacaoUseCase;
import com.itau.pj.recuperacao.domain.renegociacao.service.SimulacaoService;
import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimulacaoControllerImpl implements SimulacaoController {

    private final SimulacaoUseCase simulacaoUseCase;

    @Autowired
    public SimulacaoControllerImpl(SimulacaoUseCase simulacaoUseCase) {
        this.simulacaoUseCase = simulacaoUseCase;
    }

    @Override
    public ResponseEntity<SimulacaoOutputDTO> criarSimulacao(SimulacaoInputDTO simulacaoInputDTO) {
        Simulacao simulacao = simulacaoUseCase.criarSimulacao(simulacaoInputDTO.getDividaIds());
        SimulacaoOutputDTO simulacaoOutputDTO = mapSimulacaoToOutputDTO(simulacao);
        return ResponseEntity.ok(simulacaoOutputDTO);
    }

    @Override
    public ResponseEntity<SimulacaoOutputDTO> obterSimulacaoPorId(Long simulacaoId) {
        Simulacao simulacao = simulacaoUseCase.obterSimulacaoPorId(simulacaoId);
        SimulacaoOutputDTO simulacaoOutputDTO = mapSimulacaoToOutputDTO(simulacao);
        return ResponseEntity.ok(simulacaoOutputDTO);
    }

    @Override
    public ResponseEntity<SimulacaoOutputDTO> confirmarSimulacao(Long simulacaoId) {
        Simulacao simulacao = simulacaoUseCase.confirmarSimulacao(simulacaoId);
        SimulacaoOutputDTO simulacaoOutputDTO = mapSimulacaoToOutputDTO(simulacao);
        return ResponseEntity.ok(simulacaoOutputDTO);
    }

    private SimulacaoOutputDTO mapSimulacaoToOutputDTO(Simulacao simulacao) {
        // Implemente a lógica de mapeamento aqui
        SimulacaoOutputDTO dto = new SimulacaoOutputDTO();
        dto.setId(simulacao.getId());
        // Mapear outros campos
        return dto;
    }
}

