package com.itau.pj.recuperacao.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cobrancas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cobranca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String mensagem;
    private LocalDateTime dataEnvio;

    // Construtores
    public Cobranca(Long id, String email, String mensagem) {
        this.id = id;
        this.email = email;
        this.mensagem = mensagem;
    }
}
