package com.itau.pj.recuperacao.domain.renegociacao.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SimulacaoInputDTO {
    private List<Long> dividaIds;

    public <T> SimulacaoInputDTO(List<T> list) {
    }
}
