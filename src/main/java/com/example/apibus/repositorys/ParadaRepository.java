package com.example.apibus.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.apibus.entidade.Parada;

@RepositoryRestResource(collectionResourceRel = "parada", path = "parada" )
public interface ParadaRepository extends JpaRepository<Parada, Long>{

    List<Parada> findByparadaNome(@Param("paradaNome") String name);
    
}
