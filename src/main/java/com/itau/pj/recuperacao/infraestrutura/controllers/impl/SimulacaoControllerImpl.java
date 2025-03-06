package com.itau.pj.recuperacao.infraestrutura.controllers.impl;

import com.itau.pj.recuperacao.infraestrutura.controllers.SimulacaoController;
import com.itau.pj.recuperacao.infraestrutura.dto.in.SimulacaoInputDTO;
import com.itau.pj.recuperacao.infraestrutura.dto.out.SimulacaoOutputDTO;
import com.itau.pj.recuperacao.application.ports.in.SimulacaoUseCase;
import com.itau.pj.recuperacao.domain.model.Simulacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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

