package com.example.projetobd.dao.encomenda;

import com.example.projetobd.model.artesao.ArtesaoModel;
import com.example.projetobd.model.encomenda.EncomendaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EncomendaDaoImpl implements EncomendaDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private BeanPropertyRowMapper<EncomendaModel> rowMapper = new BeanPropertyRowMapper<EncomendaModel>(EncomendaModel.class);


    @Override
    public int save(EncomendaModel encomenda) {
        return jdbcTemplate.update("INSERT INTO encomenda(descricao,imagem_modelo,cliente_conta) values(?,?,?)",
        encomenda.getDescricao(),encomenda.getImagem_modelo(),encomenda.getCliente_conta());
    }

    @Override
    public int update(int artesao_conta, int encomenda_id) {

        return jdbcTemplate.update("UPDATE encomenda SET artesao_conta=? WHERE id=?",artesao_conta,encomenda_id);
    }

    @Override
    public int delete(int id) {

        return jdbcTemplate.update("DELETE FROM encomenda WHERE id=?",id);
    }

    @Override
    public EncomendaModel findById(int id) {

        return jdbcTemplate.queryForObject("SELECT * FROM encomenda WHERE id=?",rowMapper,id);
    }

    @Override
    public List<EncomendaModel> findAll() {
        return jdbcTemplate.query("SELECT * FROM encomenda",rowMapper);
    }
}
