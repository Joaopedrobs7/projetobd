package com.example.projetobd.controller.usuario;

import com.example.projetobd.model.usuario.usuarioModel;
import com.example.projetobd.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity<usuarioModel> buscarUsuario(@PathVariable String cpf)
    {
        usuarioModel usuarioModel = usuarioService.buscarUsuario(cpf);
        return ResponseEntity.ok(usuarioModel);

    }

    @PostMapping
    public ResponseEntity<usuarioModel> inserirUsuario(@RequestBody usuarioModel usuario){
         if (usuarioService.inserirUsuario(usuario)) {
             URI location = URI.create("/usuarios/" + usuario.getCpf());
             return ResponseEntity.created(location).body(usuario);
         }
         return ResponseEntity.badRequest().build();
    }

    @PutMapping("/editar/{cpf}")
    public ResponseEntity<usuarioModel> atualizarUsuario(@RequestBody usuarioModel usuario, @PathVariable String cpf){
         if (usuarioService.atualizarUsuario(usuario,cpf)){
             return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/deletar/{cpf}")
    public ResponseEntity<usuarioModel> deletarUsuario(@PathVariable String cpf){
        if (usuarioService.deletarUsuario(cpf)){
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.badRequest().build();
    }

}
