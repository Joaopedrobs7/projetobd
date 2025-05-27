package com.example.projetobd.dao.encomenda;

import com.example.projetobd.model.encomenda.EncomendaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class EncomendaDaoImpl implements EncomendaDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private BeanPropertyRowMapper<EncomendaModel> rowMapper = new BeanPropertyRowMapper<EncomendaModel>(EncomendaModel.class);


    @Override
    public int save(EncomendaModel encomenda) {
        String sql = "INSERT INTO encomenda (descricao, imagem_modelo, cliente_conta) VALUES (?, ?, ?)";

        // Objeto para armazenar o ID gerado
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, encomenda.getDescricao());
            ps.setString(2, encomenda.getImagem_modelo());
            ps.setInt(3, encomenda.getCliente_conta());
            return ps;
        }, keyHolder);

        // Recupera o ID e define no modelo
        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            encomenda.setId(generatedId.intValue());
        }

        return 1; // ou opcionalmente: return generatedId.intValue();
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
