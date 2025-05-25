package com.example.projetobd.controller.usuario;

import com.example.projetobd.model.usuario.usuarioModel;
import com.example.projetobd.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class usuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<usuarioModel> listarUsuarios()
    {
        return usuarioService.listarUsuarios();

    }

    @GetMapping("/{cpf}")
    public usuarioModel buscarUsuario(@PathVariable String cpf)
    {
        return usuarioService.buscarUsuario(cpf);

    }

    @PostMapping
    public String inserirUsuario(@RequestBody usuarioModel usuario){
         if (usuarioService.inserirUsuario(usuario)) {
             return "Usuario inserido com Sucesso";
         }
         return "Usuario nao inserido";
    }

    @PutMapping("/editar/{cpf}")
    public String atualizarUsuario(@RequestBody usuarioModel usuario, @PathVariable String cpf){
         if (usuarioService.atualizarUsuario(usuario,cpf)){
             return "Usuario alterado com sucesso";
        }
        return "Usuario Nao encontrado";
    }

    @DeleteMapping("/deletar/{cpf}")
    public String deletarUsuario(@PathVariable String cpf){
        if (usuarioService.deletarUsuario(cpf)){
            return "Deletado Com Sucesso";
        }
        return "Usuario Nao encontrado";
    }

}
