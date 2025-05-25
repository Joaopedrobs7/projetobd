package com.example.projetobd.dao.artesao;

import com.example.projetobd.model.artesao.ArtesaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ArtesaoDaoImpl implements ArtesaoDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    //Mapeia a consulta para a entidade UsuarioModel
    private BeanPropertyRowMapper<ArtesaoModel> rowMapper = new BeanPropertyRowMapper<ArtesaoModel>(ArtesaoModel.class);


    @Override
    public int save(ArtesaoModel artesaoModel) {
        return jdbcTemplate.update("INSERT INTO artesao(usuario_cpf) VALUES(?)",
                artesaoModel.getUsuario_cpf());

    }

    @Override
    public List<ArtesaoModel> getAll() {
        return jdbcTemplate.query("SELECT * FROM artesao",rowMapper);
    }

    @Override
    public ArtesaoModel getById(int numero_conta) {
        return jdbcTemplate.queryForObject("SELECT * FROM artesao WHERE numero_conta=?",rowMapper,numero_conta);
    }
}
