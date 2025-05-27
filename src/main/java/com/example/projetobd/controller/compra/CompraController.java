package com.example.projetobd.controller.compra;

import com.example.projetobd.model.compra.CompraModel;
import com.example.projetobd.service.CompraService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/compra")
public class CompraController {
    @Autowired
    CompraService compraService;

    @GetMapping
    public List<CompraModel> listarCompras(){
        return compraService.listarCompras();
    }

    @GetMapping("{id}")
    public ResponseEntity<CompraModel> buscarCompra(@PathVariable int id){
        CompraModel compraModel = compraService.buscarCompra(id);
        return ResponseEntity.ok(compraModel);
    }

    @PostMapping
    public ResponseEntity<CompraModel> inserirCompra(@RequestBody CompraModel compraModel){
        CompraModel compra =  compraService.inserirCompra(compraModel);
        URI location = URI.create("/compra/" + compraModel.getNumero_compra());
        return ResponseEntity.created(location).body(compra);
    }
}
