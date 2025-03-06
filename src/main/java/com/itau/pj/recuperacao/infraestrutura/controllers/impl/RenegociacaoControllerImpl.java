package com.itau.pj.recuperacao.infraestrutura.controllers.impl;

import com.itau.pj.recuperacao.infraestrutura.controllers.RenegociacaoController;
import com.itau.pj.recuperacao.infraestrutura.dto.in.RenegociacaoInputDTO;
import com.itau.pj.recuperacao.infraestrutura.dto.out.RenegociacaoOutputDTO;
import com.itau.pj.recuperacao.application.ports.in.RenegociacaoUseCase;
import com.itau.pj.recuperacao.domain.model.Renegociacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RenegociacaoControllerImpl implements RenegociacaoController {

    private final RenegociacaoUseCase renegociacaoUseCase;

    @Autowired
    public RenegociacaoControllerImpl(RenegociacaoUseCase renegociacaoUseCase) {
        this.renegociacaoUseCase = renegociacaoUseCase;
    }

    @Override
    public ResponseEntity<RenegociacaoOutputDTO> criarRenegociacao(RenegociacaoInputDTO renegociacaoInputDTO) {
        Renegociacao renegociacao = renegociacaoUseCase.criarRenegociacao(renegociacaoInputDTO.getSimulacaoId());
        RenegociacaoOutputDTO renegociacaoOutputDTO = mapRenegociacaoToOutputDTO(renegociacao);
        return ResponseEntity.ok(renegociacaoOutputDTO);
    }

    @Override
    public ResponseEntity<List<RenegociacaoOutputDTO>> listarRenegociacoes() {
        List<Renegociacao> renegociacoes = renegociacaoUseCase.listarRenegociacoes();
        List<RenegociacaoOutputDTO> renegociacaoOutputDTOs = renegociacoes.stream()
                .map(this::mapRenegociacaoToOutputDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(renegociacaoOutputDTOs);
    }

    @Override
    public ResponseEntity<RenegociacaoOutputDTO> obterRenegociacaoPorId(Long renegociacaoId) {
        Renegociacao renegociacao = renegociacaoUseCase.obterRenegociacaoPorId(renegociacaoId);
        RenegociacaoOutputDTO renegociacaoOutputDTO = mapRenegociacaoToOutputDTO(renegociacao);
        return ResponseEntity.ok(renegociacaoOutputDTO);
    }

    private RenegociacaoOutputDTO mapRenegociacaoToOutputDTO(Renegociacao renegociacao) {
        // Implemente a lógica de mapeamento aqui
        RenegociacaoOutputDTO dto = new RenegociacaoOutputDTO();
        dto.setId(renegociacao.getId());
        // Mapear outros campos
        return dto;
    }
}

