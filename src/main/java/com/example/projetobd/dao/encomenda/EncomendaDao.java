package com.example.projetobd.dao.encomenda;

import com.example.projetobd.model.encomenda.EncomendaModel;

import java.util.List;

public interface EncomendaDao {
    public int save(EncomendaModel encomenda);
    public int update(int artesao_conta, int encomenda_id);
    public int delete(int id);
    public EncomendaModel findById(int id);
    public List<EncomendaModel> findAll();
}
