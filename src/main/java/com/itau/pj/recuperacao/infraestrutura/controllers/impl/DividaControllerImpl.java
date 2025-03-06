package com.itau.pj.recuperacao.infraestrutura.controllers.impl;

import com.itau.pj.recuperacao.infraestrutura.controllers.DividaController;
import com.itau.pj.recuperacao.infraestrutura.dto.out.DividaOutputDTO;
import com.itau.pj.recuperacao.application.ports.in.DividaUseCase;
import com.itau.pj.recuperacao.domain.model.Divida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DividaControllerImpl implements DividaController {

    private final DividaUseCase dividaUseCase;

    @Autowired
    public DividaControllerImpl(DividaUseCase dividaUseCase) {
        this.dividaUseCase = dividaUseCase;
    }

    @Override
    public ResponseEntity<List<DividaOutputDTO>> listarDividas() {
        List<Divida> dividas = dividaUseCase.listarDividas();
        List<DividaOutputDTO> dividaOutputDTOs = dividas.stream()
                .map(this::mapDividaToOutputDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dividaOutputDTOs);
    }

    @Override
    public ResponseEntity<DividaOutputDTO> obterDividaPorId(Long dividaId) {
        Divida divida = dividaUseCase.obterDividaPorId(dividaId);
        DividaOutputDTO dividaOutputDTO = mapDividaToOutputDTO(divida);
        return ResponseEntity.ok(dividaOutputDTO);
    }

    private DividaOutputDTO mapDividaToOutputDTO(Divida divida) {
        // Implemente a lógica de mapeamento aqui
        DividaOutputDTO dto = new DividaOutputDTO();
        dto.setId(divida.getId());
        // Mapear outros campos
        return dto;
    }
}

