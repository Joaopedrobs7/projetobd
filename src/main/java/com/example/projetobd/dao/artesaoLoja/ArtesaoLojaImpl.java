package com.example.projetobd.dao.artesaoLoja;

import com.example.projetobd.model.artesao.ArtesaoModel;
import com.example.projetobd.model.artesaoLoja.ArtesaoLojaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtesaoLojaImpl implements ArtesaoLojaDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    // rowmapper
    private BeanPropertyRowMapper<ArtesaoLojaModel> rowMapper = new BeanPropertyRowMapper<ArtesaoLojaModel>(ArtesaoLojaModel.class);




    @Override
    public int save(ArtesaoLojaModel lojaModel) {
        return jdbcTemplate.update("INSERT INTO artesao_loja(habilidades,especialidade,artesao_conta) VALUES(?,?,?)",
                lojaModel.getHabilidades(),lojaModel.getEspecialidade(),lojaModel.getArtesao_conta());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM artesao_loja WHERE id=?",id);
    }

    @Override
    public int update(int id, ArtesaoLojaModel artesao) {
        return jdbcTemplate.update("UPDATE artesao_loja SET habilidades=?, especialidade=? WHERE id=?",
                artesao.getHabilidades(),artesao.getEspecialidade(),id);
    }

    @Override
    public ArtesaoLojaModel findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM artesao_loja WHERE id=?",rowMapper,id);
    }

    @Override
    public List<ArtesaoLojaModel> findall() {
        return jdbcTemplate.query("SELECT * FROM artesao_loja",rowMapper);
    }
}
