package com.example.projetobd.controller.artesaoLoja;

import com.example.projetobd.model.artesaoLoja.ArtesaoLojaModel;
import com.example.projetobd.service.ArtesaoLojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ArtesaoLoja")
public class ArtesaoLojaController {
    @Autowired
    private ArtesaoLojaService artesaoLojaService;

    @GetMapping
    public List<ArtesaoLojaModel> listarLojas(){
        return artesaoLojaService.listarLojas();
    }

    @GetMapping("{id}")
    public ArtesaoLojaModel buscarLoja(@PathVariable int id){
        return artesaoLojaService.buscarLoja(id);
    }

    @PostMapping
    public ResponseEntity<ArtesaoLojaModel> inserirLoja(@RequestBody ArtesaoLojaModel lojaModel){
        if (artesaoLojaService.inserirLoja(lojaModel)) {
            URI location = URI.create("ArtesaoLoja/" + lojaModel.getId());
            return ResponseEntity.created(location).body(lojaModel);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ArtesaoLojaModel> editarLoja(@PathVariable int id,@RequestBody ArtesaoLojaModel lojaModel){
        if (artesaoLojaService.editarLoja(id,lojaModel)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<ArtesaoLojaModel> deletarLoja(@PathVariable int id){
        if (artesaoLojaService.deletarLoja(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }
}

