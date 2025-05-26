package com.example.projetobd.dao.encomenda;

import com.example.projetobd.model.encomenda.EncomendaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EncomendaDaoImpl implements EncomendaDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(EncomendaModel encomenda) {
        return 0;
    }

    @Override
    public int update(EncomendaModel encomenda) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public EncomendaModel findById(int id) {
        return null;
    }

    @Override
    public List<EncomendaModel> findAll() {
        return List.of();
    }
}
