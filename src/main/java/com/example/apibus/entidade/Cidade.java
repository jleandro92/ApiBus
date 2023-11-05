package com.example.apibus.entidade;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Table(name = "cidades")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCidade;
    private String estado;
    private String pais;

    @OneToMany(mappedBy = "cidade")
    private List<Parada> paradas;
}
