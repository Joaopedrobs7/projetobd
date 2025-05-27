package com.example.projetobd.controller.artesao;

import com.example.projetobd.model.artesao.ArtesaoModel;
import com.example.projetobd.service.ArtesaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/artesao")

public class ArtesaoController {
    @Autowired
    private ArtesaoService artesaoService;

    //GET ALL
    @GetMapping
    public List<ArtesaoModel> listarArtesaos(){
        return artesaoService.listarArtesaos();
    }

    @GetMapping("{id}")
    public ArtesaoModel buscarArtesao(@PathVariable int id){
        return artesaoService.buscarArtesao(id);
    }

    //INSERT
    @PostMapping
    public ResponseEntity<ArtesaoModel> inserirArtesao(@RequestBody ArtesaoModel artesao){
        if (artesaoService.inserirArtesao(artesao)){
            URI location = URI.create("/artesao/" + artesao.getNumero_conta());
            return ResponseEntity.created(location).body(artesao);
        }
        return ResponseEntity.badRequest().build();
    }


}
