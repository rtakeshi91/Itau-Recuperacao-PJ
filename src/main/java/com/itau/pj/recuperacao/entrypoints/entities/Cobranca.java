package com.itau.pj.recuperacao.entrypoints.entities;

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
}
