package com.example.projetobd.service;

import com.example.projetobd.dao.artesaoLoja.ArtesaoLojaDao;
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
            return null;
        }
    }

    //save
    public boolean inserirLoja(ArtesaoLojaModel lojaModel) {
        if (artesaoLojaDao.save(lojaModel) == 1) {
            return true;
        }
        else{
            return false;
        }
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
