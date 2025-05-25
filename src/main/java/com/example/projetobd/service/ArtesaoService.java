package com.example.projetobd.service;

import com.example.projetobd.dao.artesao.ArtesaoDao;
import com.example.projetobd.dao.usuario.usuarioDao;
import com.example.projetobd.model.artesao.ArtesaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtesaoService {
    @Autowired
    private ArtesaoDao aDao;
    @Autowired
    private usuarioDao uDao;

    public List<ArtesaoModel> listarArtesaos() {
        return aDao.getAll();
    }

    public boolean inserirArtesao(ArtesaoModel artesao) {
        try{
             if (uDao.getByCpf(artesao.getUsuario_cpf()) != null){
                 aDao.save(artesao);
                 return true;
             }
            else{
                return false;
             }
        }
        catch(EmptyResultDataAccessException e){
            return false;
        }

    }

    public ArtesaoModel buscarArtesao(int id) {
            try{
                return aDao.getById(id);
            }
            catch (EmptyResultDataAccessException e){
                return null;
            }
    }
}
