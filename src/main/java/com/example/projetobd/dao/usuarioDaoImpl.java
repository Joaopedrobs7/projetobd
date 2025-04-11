package com.example.projetobd.dao;

import com.example.projetobd.model.usuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class usuarioDaoImpl implements usuarioDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(usuarioModel usuario) {
        return 0;
    }

    @Override
    public int update(usuarioModel usuario, String cpf) {
        return 0;
    }

    @Override
    public int delete(String cpf) {
        return 0;
    }

    @Override
    public List<usuarioModel> getAll() {
        return jdbcTemplate.query("SELECT * FROM usuario", new BeanPropertyRowMapper<usuarioModel>(usuarioModel.class));
    }

    @Override
    public usuarioModel getByCpf(String cpf) {
        return null;
    }
}
