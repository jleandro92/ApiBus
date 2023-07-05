package com.example.apibus.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apibus.entidade.Rota;
import com.example.apibus.servicos.RotaService;

@RestController
public class RotaController {
    
    @Autowired
    private RotaService rotaService;


    @PutMapping("rota/{rotaId}/addParada/{paradaId}")
    public Rota addParada (@PathVariable("rotaId") Long rotaId,
     @PathVariable("paradaId") Long paradaId){

        return rotaService.addParada(rotaId,paradaId);

     }
         @PutMapping("rota/{rotaId}/addOnibus/{onibusId}")
        public Rota addOnibus (@PathVariable("rotaId") Long rotaId,
        @PathVariable("onibusId") Long onibusId){

        return rotaService.addOnibus(rotaId, onibusId);
   }
}
