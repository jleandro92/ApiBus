package com.example.apibus.entidade;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table (name = "rotas")
@Getter @Setter
public class Rota {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column (name = "codigo")
  private Long id;

  @Column (name = "nomeRota")
  private String nomeRota;

  @Column (name = "horaSaida")
  private String horaSaida;

  @Column (name = "horaChegada")
  private String horaChegada;//hora prevista da chegada ao destino

  @Column (name = "valorLinha")
  private Float  valorLinha;

  @OneToMany(mappedBy = "rota")
  private List<Onibus> onibus;

  @OneToMany(mappedBy = "rota")
  private List<Parada> paradas;
    
}




 