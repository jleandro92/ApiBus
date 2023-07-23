package com.example.apibus.controles;

import com.example.apibus.entidade.Onibus;
import com.example.apibus.repositorys.OnibusRepository;
import com.example.apibus.servicos.OnibusService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OnibusController {

    @Autowired
    private OnibusService onibusService;

    @Autowired
    private OnibusRepository onibusRepository;

    @GetMapping("/onibus/")
    public List<Onibus> listBus(){
        List<Onibus> listBus = onibusRepository.findAll();
        
        return listBus;
    }

    @PutMapping("onibus/{onibusId}/addParadaBus/{paradaId}")
    public Onibus addParadaBus (@PathVariable("onibusId") Long onibusId,
                                @PathVariable("paradaId") Long paradaId){
        return onibusService.addParadaBus(onibusId,paradaId);
    }
}
