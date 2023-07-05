package com.example.apibus.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter @Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "coduser")
    private Long id;
    @Email
    @Column (name = "email")
    private String email;

    @Column (name = "nomeUser")
    @Size(min = 3, max = 20, message = "Usuario deve informa um nome real")
    private String nomeUser;

    @Column (name = "senha")
    private String senha;
}
