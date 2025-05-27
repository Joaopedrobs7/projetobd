package com.example.projetobd.controller.avaliacao;

import com.example.projetobd.model.avaliacao.AvaliacaoModel;
import com.example.projetobd.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {
    @Autowired
    AvaliacaoService avaliacaoService;

    @GetMapping
    public List<AvaliacaoModel> listarAvaliacoes(){
        return avaliacaoService.listarAvaliacoes();
    }

    @GetMapping("{avaliacao_id}")
    public ResponseEntity<AvaliacaoModel> buscarAvaliacao(@PathVariable int avaliacao_id){
        AvaliacaoModel avaliacao = avaliacaoService.buscarAvaliacao(avaliacao_id);
        return ResponseEntity.ok(avaliacao);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoModel> inserirAvaliacao(@RequestBody AvaliacaoModel avaliacaoModel){
        if (avaliacaoService.inserirAvaliacao(avaliacaoModel)){
            URI location = URI.create("/encomenda/" + avaliacaoModel.getId());
            return ResponseEntity.created(location).body(avaliacaoModel);
        }
        return ResponseEntity.notFound().build();
    }

}
