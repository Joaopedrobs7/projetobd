package com.example.projetobd.controller.produto;

import com.example.projetobd.model.produto.produtoModel;
import com.example.projetobd.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")

public class produtoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<produtoModel> listarProdutos(){
        return produtoService.listarProdutos();

    }

    @GetMapping("{cod}")
    public produtoModel buscarProduto(@PathVariable int cod)
    {
        return produtoService.buscarProduto(cod);
    }

    @PostMapping
    public ResponseEntity<produtoModel> inserirProduto(@RequestBody produtoModel produto){
        if (produtoService.inserirProduto(produto)){
            URI location = URI.create("/produtos/"+ produto.getCod());
            return ResponseEntity.created(location).body(produto);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/deletar/{cod}")
    public ResponseEntity<produtoModel> deletarProduto(@PathVariable int cod){
        if (produtoService.deletarProduto(cod)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/editar/{cod}")
    public ResponseEntity<produtoModel> atualizarProduto(@RequestBody produtoModel produto, @PathVariable int cod){
        if (produtoService.atualizarProduto(produto,cod)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();

    }
}
