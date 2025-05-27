package com.example.projetobd.service;

import com.example.projetobd.dao.cliente.ClienteDao;
import com.example.projetobd.dao.compra.CompraDao;
import com.example.projetobd.dao.encomenda.EncomendaDao;
import com.example.projetobd.exception.RecursoNaoEncontradoException;
import com.example.projetobd.model.compra.CompraModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {
    @Autowired
    CompraDao cDao;
    @Autowired
    EncomendaDao eDao;

    public List<CompraModel> listarCompras() {
        return cDao.findall();
    }

    public CompraModel inserirCompra(CompraModel compraModel) {
        //tipo encomenda com id null
        if (compraModel.getTipo_compra().equals("encomenda")){
            if(compraModel.getEncomenda_id() == null){
                throw new IllegalArgumentException("encomenda_id é obrigatório para tipo 'encomenda'");
            }
        }

        try{
            int id = cDao.save(compraModel);
            return cDao.findById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new RecursoNaoEncontradoException("Cliente/Encomenda nao existe");
        }

    }

    public CompraModel buscarCompra(int id) {
        try{
            return cDao.findById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new RecursoNaoEncontradoException("Compra com id " + id + " não encontrada.");
        }
    }
}
