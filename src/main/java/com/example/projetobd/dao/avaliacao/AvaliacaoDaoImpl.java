package com.example.projetobd.dao.avaliacao;

import com.example.projetobd.model.avaliacao.AvaliacaoModel;
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
public class AvaliacaoDaoImpl implements AvaliacaoDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    //Rowmapper
    private BeanPropertyRowMapper<AvaliacaoModel> rowMapper = new BeanPropertyRowMapper<AvaliacaoModel>(AvaliacaoModel.class);


    @Override
    public int save(AvaliacaoModel avaliacaoModel) {
        String sql = "INSERT INTO avaliacao(nota,titulo,descricao,num_compra) VALUES(?,?,?,?)";

        // Objeto para armazenar o ID gerado
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, avaliacaoModel.getNota());
            ps.setString(2, avaliacaoModel.getTitulo());
            ps.setString(3, avaliacaoModel.getDescricao());
            ps.setInt(4,avaliacaoModel.getNum_compra());
            return ps;
        }, keyHolder);

        // Recupera o ID e define no modelo
        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            avaliacaoModel.setId(generatedId.intValue());
        }

        return 1; // ou opcionalmente: return generatedId.intValue();

    }

    @Override
    public AvaliacaoModel findById(int avaliacao_id) {
        return jdbcTemplate.queryForObject("SELECT * FROM avaliacao WHERE id=?",rowMapper,avaliacao_id);
    }

    @Override
    public List<AvaliacaoModel> findall() {
        return jdbcTemplate.query("SELECT * FROM avaliacao",rowMapper);
    }

    @Override
    public boolean existsByNumCompra(int numCompra) {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM avaliacao WHERE num_compra = ?", Integer.class, numCompra);
        return count != null && count > 0;
    }
}
