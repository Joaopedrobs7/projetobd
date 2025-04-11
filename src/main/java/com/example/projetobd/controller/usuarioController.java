package com.example.projetobd.controller;

import com.example.projetobd.dao.usuarioDao;
import com.example.projetobd.model.usuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
