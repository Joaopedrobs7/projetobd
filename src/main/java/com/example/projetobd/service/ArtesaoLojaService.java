package com.example.projetobd.service;

import com.example.projetobd.dao.artesaoLoja.ArtesaoLojaDao;
import com.example.projetobd.exception.RecursoNaoEncontradoException;
import com.example.projetobd.model.artesaoLoja.ArtesaoLojaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtesaoLojaService {
    @Autowired
    ArtesaoLojaDao artesaoLojaDao;

    //get all
    public List<ArtesaoLojaModel> listarLojas() {
        return artesaoLojaDao.findall();
    }

    //findById
    public ArtesaoLojaModel buscarLoja(int id) {
        try{
            return artesaoLojaDao.findById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new RecursoNaoEncontradoException("Loja nao existe");
        }
    }

    //save
    public boolean inserirLoja(ArtesaoLojaModel lojaModel) {
        return artesaoLojaDao.save(lojaModel) == 1;
    }

    //update
    public boolean editarLoja(int id, ArtesaoLojaModel lojaModel) {
        if (artesaoLojaDao.update(id,lojaModel) ==1){
            return true;
        }
        return false;
    }

    //delete
    public boolean deletarLoja(int id) {
        if (artesaoLojaDao.delete(id) == 1){
            return true;
        }
        return false;
    }






}
