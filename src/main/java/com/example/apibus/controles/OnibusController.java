package com.example.apibus.controles;

import com.example.apibus.entidade.Onibus;
import com.example.apibus.servicos.OnibusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnibusController {

    @Autowired
    private OnibusService onibusService;

    @PutMapping("onibus/{onibusId}/addParadaBus/{paradaId}")
    public Onibus addParadaBus (@PathVariable("onibusId") Long onibusId,
                                @PathVariable("paradaId") Long paradaId){
        return onibusService.addParadaBus(onibusId,paradaId);
    }
}
