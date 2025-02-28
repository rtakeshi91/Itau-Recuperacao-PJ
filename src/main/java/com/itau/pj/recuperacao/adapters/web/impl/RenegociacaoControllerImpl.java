package com.itau.pj.recuperacao.adapters.web.impl;

import com.itau.pj.recuperacao.adapters.web.RenegociacaoController;
import com.itau.pj.recuperacao.domain.renegociacao.dto.input.RenegociacaoInputDTO;
import com.itau.pj.recuperacao.domain.renegociacao.dto.output.RenegociacaoOutputDTO;
import com.itau.pj.recuperacao.domain.renegociacao.model.RenegociacaoUseCase;
import com.itau.pj.recuperacao.entrypoints.entities.Divida;
import com.itau.pj.recuperacao.entrypoints.entities.Renegociacao;
import com.itau.pj.recuperacao.entrypoints.entities.Simulacao;
import com.itau.pj.recuperacao.domain.renegociacao.service.DividaService;
import com.itau.pj.recuperacao.domain.renegociacao.service.RenegociacaoService;
import com.itau.pj.recuperacao.domain.renegociacao.service.SimulacaoService;
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

