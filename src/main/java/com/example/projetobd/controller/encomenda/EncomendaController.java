package com.example.projetobd.controller.encomenda;

import com.example.projetobd.model.encomenda.EncomendaModel;
import com.example.projetobd.service.EncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/encomenda")


public class EncomendaController {
    @Autowired
    EncomendaService encomendaService;

    @GetMapping
    public List<EncomendaModel> listarEncomendas(){
        return encomendaService.listarEncomendas();
    }

    @GetMapping("{id}")
//    public EncomendaModel buscarEncomenda(@PathVariable int id){
//        return encomendaService.buscarEncomenda(id);
//    }
    public ResponseEntity<EncomendaModel> buscarEncomenda(@PathVariable int id){
        EncomendaModel encomenda = encomendaService.buscarEncomenda(id);
        return ResponseEntity.ok(encomenda);
    }

    @PostMapping
    public ResponseEntity<EncomendaModel> inserirEncomenada(@RequestBody EncomendaModel encomenda){
//        if (encomendaService.inserirEncomenda(encomenda)){
//            return "Inserido Com sucesso";
//        }
//        return "Ocorreu um erro";
        if (encomendaService.inserirEncomenda(encomenda)){
            URI location = URI.create("/encomenda/" + encomenda.getId());
            return ResponseEntity.created(location).body(encomenda);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/editar/{encomenda_id}")
    public ResponseEntity<EncomendaModel> editarEncomenda(@PathVariable int encomenda_id, @RequestBody EncomendaModel encomenda){
        EncomendaModel encomendaModel = encomendaService.editarEncomenda(encomenda.getArtesao_conta(),encomenda_id);
        return ResponseEntity.ok(encomendaModel);
    }

    @DeleteMapping("/deletar/{encomenda_id}")
    public ResponseEntity<Void> deletarEncomenda(@PathVariable int encomenda_id){
        encomendaService.deletarEncomenda(encomenda_id);
        return ResponseEntity.noContent().build();
    }

}
