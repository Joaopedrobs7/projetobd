package com.example.projetobd.dao.encomenda;

import com.example.projetobd.model.encomenda.EncomendaModel;

import java.util.List;

public interface EncomendaDao {
    public int save(EncomendaModel encomenda);
    public int update(EncomendaModel encomenda);
    public int delete(int id);
    public EncomendaModel findById(int id);
    public List<EncomendaModel> findAll();
}
