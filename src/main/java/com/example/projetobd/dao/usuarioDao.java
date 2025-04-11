package com.example.projetobd.dao;

import com.example.projetobd.model.usuarioModel;

import java.util.List;

public interface usuarioDao {
    int save(usuarioModel usuario);

    int update(usuarioModel usuario,String cpf);

    int delete(String cpf);

    List<usuarioModel> getAll();

    usuarioModel getByCpf(String cpf);
}
