package com.example.projetobd.controller.produtoCompra;

import com.example.projetobd.model.produtoCompra.ProdutoCompraModel;
import com.example.projetobd.service.ProdutoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/produtocompra")

public class ProdutoCompraController {
    @Autowired
    ProdutoCompraService produtoCompraService;

    @GetMapping
    public List<ProdutoCompraModel> listarProdutoCompra(){
        return produtoCompraService.listarProdutoCompra();
    }

    @GetMapping("{compra_id}")
    public List<ProdutoCompraModel> buscarProdutosPorCompra(@PathVariable int compra_id){
        return produtoCompraService.buscarProdutosPorCompra(compra_id);
    }

    @PostMapping
    public ResponseEntity<ProdutoCompraModel> inserirProdutoCompra(@RequestBody ProdutoCompraModel produtoCompraModel){
        if(produtoCompraService.inserirProdutoCompra(produtoCompraModel)){
            URI location = URI.create("/produtocompra/");
            return ResponseEntity.created(location).body(produtoCompraModel);
        }
        return ResponseEntity.badRequest().build();
    }
}
