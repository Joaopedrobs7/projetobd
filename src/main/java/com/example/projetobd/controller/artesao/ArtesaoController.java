package com.example.projetobd.controller.artesao;

import com.example.projetobd.model.artesao.ArtesaoModel;
import com.example.projetobd.service.ArtesaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String inserirArtesao(@RequestBody ArtesaoModel artesao){
        if (artesaoService.inserirArtesao(artesao)){
            return "Inserido com Sucesso";
        }
        return "Usuário não Existe";
    }


}
