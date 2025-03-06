package com.itau.pj.recuperacao.infraestrutura.dto.in;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CobrancaInputDTO {
    private String email;
    private String mensagem;

    public CobrancaInputDTO(String mail, String teste) {
    }
}
