package com.example.projetobd.controller;

import com.example.projetobd.dao.usuarioDao;
import com.example.projetobd.model.usuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class usuarioController {

    @Autowired
    private usuarioDao uDao;

    @GetMapping
    public List<usuarioModel> listarUsuarios(){
        return uDao.getAll();
    }

    @GetMapping("/{cpf}")
    public usuarioModel buscarUsuario(@PathVariable String cpf){
        return uDao.getByCpf(cpf);
    }

    @PostMapping
    public String inserirUsuario(@RequestBody usuarioModel usuario){
         uDao.save(usuario);
         return "Usuario inserido com Sucesso";
    }

    @PutMapping("/editar/{cpf}")
    public String atualizarUsuario(@RequestBody usuarioModel usuario, @PathVariable String cpf){
         if ( (uDao.update(usuario,cpf)) == 1 ){
             return "Usuario alterado com sucesso";
        }
        return "Usuario Nao encontrado";
    }

    @DeleteMapping("/deletar/{cpf}")
    public String deletarUsuario(@PathVariable String cpf){
        if ( uDao.delete(cpf) == 1){
            return "Deletado Com Sucesso";
        }
        return "Usuario Nao encontrado";
    }

}
