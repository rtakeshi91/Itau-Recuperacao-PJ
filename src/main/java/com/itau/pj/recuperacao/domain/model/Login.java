package com.itau.pj.recuperacao.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String login;

    @Column
    private String senha;

    public Login(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Login(String usuario) {
        this.login = usuario;
    }
}
