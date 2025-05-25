package com.example.projetobd.controller.produto;

import com.example.projetobd.model.produto.produtoModel;
import com.example.projetobd.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String inserirProduto(@RequestBody produtoModel produto){
        produtoService.inserirProduto(produto);
        return "Produto inserido com Sucesso";
    }

    @DeleteMapping("/deletar/{cod}")
    public String deletarProduto(@PathVariable int cod){
        if (produtoService.deletarProduto(cod)) {
            return "Produto Deletado com Sucesso";
        }
        return "Produto nao Encotrado";
    }

    @PutMapping("/editar/{cod}")
    public String atualizarProduto(@RequestBody produtoModel produto, @PathVariable int cod){
        if (produtoService.atualizarProduto(produto,cod)) {
            return "Alterado com Sucesso";
        }
        return "Produto nao Encontrado";

    }
}
