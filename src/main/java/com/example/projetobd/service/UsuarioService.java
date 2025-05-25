package com.example.projetobd.service;

import com.example.projetobd.dao.usuario.usuarioDao;
import com.example.projetobd.model.usuario.usuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private usuarioDao uDao;



    public List<usuarioModel> listarUsuarios(){
        return uDao.getAll();
    }


    public usuarioModel buscarUsuario(String cpf){

        try{
            return uDao.getByCpf(cpf);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }


    public Boolean inserirUsuario(usuarioModel usuario){

        if ( uDao.save(usuario) == 1) {
            return true;
        }
        return false;


    }


    public Boolean atualizarUsuario(usuarioModel usuario,String cpf){
        if ( (uDao.update(usuario,cpf)) == 1 ){
            return true;
        }
        return false;
    }


    public Boolean deletarUsuario(String cpf){
        if ( uDao.delete(cpf) == 1){
            return true;
        }
        return false;
    }


}
