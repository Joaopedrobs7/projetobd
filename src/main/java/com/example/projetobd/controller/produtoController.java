package com.example.projetobd.controller;

import com.example.projetobd.dao.produtoDao;
import com.example.projetobd.model.produtoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")

public class produtoController {
    @Autowired
    private produtoDao pDao;

    @GetMapping
    public List<produtoModel> listarProdutos(){
        return pDao.getAll();

    }

    @GetMapping("{cod}")
    public produtoModel buscarProduto(@PathVariable int cod){
        return pDao.getById(cod);
    }

    @PostMapping
    public String inserirProduto(@RequestBody produtoModel produto){
        pDao.save(produto);
        return "Produto inserido com Sucesso";
    }

    @DeleteMapping("/deletar/{cod}")
    public String deletarProduto(@PathVariable int cod){
        if (pDao.delete(cod) == 1){
            return "Produto Deletado com Sucesso";
        }
        return "Produto nao Encotrado";
    }

    @PutMapping("/editar/{cod}")
    public String atualizarProduto(@RequestBody produtoModel produto, @PathVariable int cod){
        if(pDao.update(produto,cod) == 1){
            return "Alterado com Sucesso";
        }
        return "Produto nao Encontrado";
    }
}
