package com.example.projetobd.controller;

import com.example.projetobd.dao.usuarioDao;
import com.example.projetobd.model.usuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioPageController {

    @Autowired
    private usuarioDao uDao;

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", uDao.getAll());
        model.addAttribute("usuario", new usuarioModel());
        return "usuarios";
    }

    @PostMapping("/add")
    public String inserirUsuario(@ModelAttribute usuarioModel usuario) {
        uDao.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/delete/{cpf}")
    public String deletarUsuario(@PathVariable String cpf) {
        uDao.delete(cpf);
        return "redirect:/usuarios";
    }
}
