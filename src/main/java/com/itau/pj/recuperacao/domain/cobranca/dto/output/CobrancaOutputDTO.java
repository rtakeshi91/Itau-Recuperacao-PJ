package com.itau.pj.recuperacao.domain.cobranca.dto.output;

import com.itau.pj.recuperacao.entrypoints.entities.Cobranca;
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

