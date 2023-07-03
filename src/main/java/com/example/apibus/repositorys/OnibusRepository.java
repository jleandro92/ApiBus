package com.example.apibus.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.apibus.entidade.Onibus;

@RepositoryRestResource(collectionResourceRel = "onibus", path = "onibus")
public interface OnibusRepository extends JpaRepository <Onibus, Long> {
    
    List<Onibus> findBynumOnibus (@Param("numOnibus") Integer number);



}
