package com.example.apibus.servicos;

import com.example.apibus.entidades.Rota;

public interface RotaService {
    
    Rota addParada(Long rotaId, Long paradaId);
    
    Rota addOnibus(Long rotaId, Long OnibusIs);


}
