package com.example.projetobd.service;

import com.example.projetobd.dao.avaliacao.AvaliacaoDao;
import com.example.projetobd.exception.ForaDoPadraoException;
import com.example.projetobd.exception.RecursoNaoEncontradoException;
import com.example.projetobd.model.avaliacao.AvaliacaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {
    @Autowired
    AvaliacaoDao aDao;

    public List<AvaliacaoModel> listarAvaliacoes() {
        return aDao.findall();
    }

    public AvaliacaoModel buscarAvaliacao(int avaliacao_id) {
        try{
            return aDao.findById(avaliacao_id);
        }
        catch (EmptyResultDataAccessException e){
            throw new RecursoNaoEncontradoException("Avaliacao Nao Existe");
        }
    }

    public Boolean inserirAvaliacao(AvaliacaoModel avaliacaoModel) {
        try {
            return aDao.save(avaliacaoModel) == 1;
        }
        catch (UncategorizedSQLException e){
            throw new ForaDoPadraoException("Avaliacao Deve ser entre 1-5");
        }
        catch (DataIntegrityViolationException e){
            throw new RecursoNaoEncontradoException("Compra Nao existe");
        }
    }
}
