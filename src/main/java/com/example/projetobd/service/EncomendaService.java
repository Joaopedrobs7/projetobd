package com.example.projetobd.service;

import com.example.projetobd.dao.encomenda.EncomendaDao;
import com.example.projetobd.exception.RecursoNaoEncontradoException;
import com.example.projetobd.model.encomenda.EncomendaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncomendaService {
    @Autowired
    EncomendaDao eDao;


    public List<EncomendaModel> listarEncomendas() {
        return eDao.findAll();
    }

    public EncomendaModel buscarEncomenda(int id) {
        try {
            return eDao.findById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new RecursoNaoEncontradoException("Encomenda com id " + id + " não encontrada.");
        }
    }

    public boolean inserirEncomenda(EncomendaModel encomenda) {
        try{
            return eDao.save(encomenda) == 1;
        }
        catch (DataIntegrityViolationException e){
            throw new RecursoNaoEncontradoException("Cliente nao existe");
        }

    }

    public EncomendaModel editarEncomenda(int id, int encomenda_id) {
        try{
            if (eDao.update(id,encomenda_id) == 1){
                return eDao.findById(encomenda_id);
            }
            else {
                throw new RecursoNaoEncontradoException("Encomenda nao existe");
            }
        }
        catch (DataIntegrityViolationException e){
            throw new RecursoNaoEncontradoException("Artesao nao existe");
        }

    }

    public boolean deletarEncomenda(int encomendaId) {
        if (eDao.delete(encomendaId) == 1){
            return true;
        }
        throw new RecursoNaoEncontradoException("Encomenda nao existe");
    }


    //todo delete



}
