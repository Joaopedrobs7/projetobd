package com.example.projetobd.controller.artesaoLoja;

import com.example.projetobd.model.artesaoLoja.ArtesaoLojaModel;
import com.example.projetobd.service.ArtesaoLojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String inserirLoja(@RequestBody ArtesaoLojaModel lojaModel){
        if (artesaoLojaService.inserirLoja(lojaModel)) {
            return "Inserido com Sucesso";
        }
        return "Nao foi inserido";
    }

    @PutMapping("/editar/{id}")
    public String editarLoja(@PathVariable int id,@RequestBody ArtesaoLojaModel lojaModel){
        if (artesaoLojaService.editarLoja(id,lojaModel)){
            return "Loja editada com Sucesso";
        }
        return "Loja nao existe";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarLoja(@PathVariable int id){
        if (artesaoLojaService.deletarLoja(id)){
            return "Loja deletada com Sucesso";
        }
        return "Loja nao Existe";
    }
}

