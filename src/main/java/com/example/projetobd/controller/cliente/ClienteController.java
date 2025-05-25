package com.example.projetobd.controller.cliente;

import com.example.projetobd.model.cliente.ClienteModel;
import com.example.projetobd.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String inserirCliente(@RequestBody ClienteModel cliente){
        if (clienteService.InserirCliente(cliente)) {
            return "Inserido com Sucesso";
        }
        else {
            return "Usuário não Existe";
        }
    }

}
