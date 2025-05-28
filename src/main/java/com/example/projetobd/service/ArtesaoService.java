package com.example.projetobd.service;

import com.example.projetobd.dao.artesao.ArtesaoDao;
import com.example.projetobd.dao.usuario.usuarioDao;
import com.example.projetobd.exception.FalhaDeIntegridade;
import com.example.projetobd.exception.RecursoNaoEncontradoException;
import com.example.projetobd.model.artesao.ArtesaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

    public ArtesaoModel inserirArtesao(ArtesaoModel artesao) {
        try{
             if (uDao.getByCpf(artesao.getUsuario_cpf()) != null){
                 aDao.save(artesao);
                 return artesao;
             }
            else{
                 throw new RecursoNaoEncontradoException("CPF de usuário não existe para criar Artesao.");
             }
        }
        catch(EmptyResultDataAccessException e){
            throw new RecursoNaoEncontradoException("CPF de usuário não existe para criar Artesao.");
        }
        catch (DuplicateKeyException e){
            throw new FalhaDeIntegridade("CPF já está em uso por outro Artesao.");
        }

    }

    public ArtesaoModel buscarArtesao(int id) {
            try{
                return aDao.getById(id);
            }
            catch (EmptyResultDataAccessException e){
                throw new RecursoNaoEncontradoException("Artesao Nao existe");
            }
    }
}
