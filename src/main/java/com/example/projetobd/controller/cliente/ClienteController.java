package com.example.projetobd.controller.cliente;

import com.example.projetobd.model.cliente.ClienteModel;
import com.example.projetobd.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")

public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    // GET ALL
    @GetMapping
    public List<ClienteModel> listarClientes(){
        return clienteService.listarClientes();
    }

    // GET BY CPF
    @GetMapping("{id}")
    public ClienteModel buscarCliente(@PathVariable int id){
        return clienteService.buscarCliente(id);
    }

    //INSERT CLIENT
    @PostMapping
    public ResponseEntity<ClienteModel> inserirCliente(@RequestBody ClienteModel cliente){
        ClienteModel novoCliente = clienteService.InserirCliente(cliente);
        URI location = URI.create("/clientes/" + novoCliente.getNumero_conta());
        return ResponseEntity.created(location).body(novoCliente);
    }

}
