package com.itau.pj.recuperacao.infraestrutura.dto.out;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CobrancaOutputDTO {
    private Long id;
    private String email;
    private String mensagem;

    // Construtores, getters e setters
    public CobrancaOutputDTO(Long id, String email, String mensagem) {
        this.id = id;
        this.email = email;
        this.mensagem = mensagem;
    }

    // Getters e setters
}

