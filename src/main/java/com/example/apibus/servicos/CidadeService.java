package com.example.apibus.servicos;

import com.example.apibus.entidade.Cidade;
import com.example.apibus.entidade.Parada;
import com.example.apibus.repositorys.CidadeRepository;
import com.example.apibus.repositorys.ParadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService implements CidadeImpl {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ParadaRepository paradaRepository;

    public List<Cidade> listarCidades() {
        return cidadeRepository.findAll();
    }

    public Cidade getCidade(Long id) {
        return cidadeRepository.findById(id).orElse(null);
    }

    public Cidade criarCidade(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public Cidade atualizarCidade(Long id, Cidade cidade) {
        if (cidadeRepository.existsById(id)) {
            cidade.setId(id);
            return cidadeRepository.save(cidade);
        }
        return null;
    }

    public boolean excluirCidade(Long id) {
        if (cidadeRepository.existsById(id)) {
            cidadeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Cidade addParada(Long cidadeId, Long paradaId){
        Cidade cidade = cidadeRepository.findById(cidadeId).get();
        Parada parada = paradaRepository.findById(paradaId).get();
        parada.setCidade(cidade);
        paradaRepository.save(parada);

        return cidade;
    }
}


