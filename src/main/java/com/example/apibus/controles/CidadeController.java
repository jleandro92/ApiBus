package com.example.apibus.controles;

import com.example.apibus.entidade.Cidade;
import com.example.apibus.servicos.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/cidade/")
    public List<Cidade> listarCidades() {
        return cidadeService.listarCidades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getCidade(@PathVariable Long id) {
        Cidade cidade = cidadeService.getCidade(id);
        if (cidade != null) {
            return ResponseEntity.ok(cidade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cidade/")
    public Cidade criarCidade(@RequestBody Cidade cidade) {
        return cidadeService.criarCidade(cidade);
    }

    @PutMapping("cidade/{cidadeId}/addParada/{paradaId}")
    public Cidade addParada(@PathVariable("cidadeId") Long cidadeId,
                                @PathVariable("paradaId") Long paradaId){
        return cidadeService.addParada(cidadeId,paradaId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> atualizarCidade(@PathVariable Long id, @RequestBody Cidade cidade) {
        Cidade cidadeAtualizada = cidadeService.atualizarCidade(id, cidade);
        if (cidadeAtualizada != null) {
            return ResponseEntity.ok(cidadeAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCidade(@PathVariable Long id) {
        boolean sucesso = cidadeService.excluirCidade(id);
        if (sucesso) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

