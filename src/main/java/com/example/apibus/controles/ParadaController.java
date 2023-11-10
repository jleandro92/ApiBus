package com.example.apibus.controles;

import com.example.apibus.entidade.Cidade;
import com.example.apibus.entidade.Parada;
import com.example.apibus.entidade.ParadaForm;
import com.example.apibus.entidade.Rota;
import com.example.apibus.repositorys.CidadeRepository;
import com.example.apibus.repositorys.ParadaRepository;
import com.example.apibus.repositorys.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ParadaController {

    @Autowired
    private ParadaRepository paradaRepository;

    @Autowired
    private RotaRepository rotaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("/parada/")
    public List<Parada> paradaList(){
        List<Parada> paradaList = paradaRepository.findAll();

        return paradaList;
    }

    @PostMapping("/parada/")
    public ResponseEntity<Object> saveParada(@RequestBody ParadaForm pf) {
        try {
            Parada parada = new Parada();
            parada.setParadaNome(pf.getParadaNome());
            parada.setPosicao(pf.getPosicao());

            if (pf.getRota_id() != null && rotaRepository.existsById(pf.getRota_id())) {
                Rota rota = rotaRepository.findById(pf.getRota_id()).get();
                parada.setRota(rota);
            }

            if (pf.getCidade_id() != null && cidadeRepository.existsById(pf.getCidade_id())) {
                Cidade cidade = cidadeRepository.findById(pf.getCidade_id()).get();
                parada.setCidade(cidade);
            }

            Parada savedParada = paradaRepository.save(parada);
            return ResponseEntity.ok(savedParada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar a parada");
        }
    }
}
