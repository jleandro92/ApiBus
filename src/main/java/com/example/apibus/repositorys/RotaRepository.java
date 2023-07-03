package com.example.apibus.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.apibus.entidade.Rota;

@RepositoryRestResource(collectionResourceRel = "rota", path = "rota")
public interface RotaRepository extends JpaRepository <Rota, Long> {

     List<Rota> findBynomeRota(@Param("nomeRota") String name);
}
