package com.example.projetobd.dao.artesao;

import com.example.projetobd.model.artesao.ArtesaoModel;
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
public class ArtesaoDaoImpl implements ArtesaoDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    //Mapeia a consulta para a entidade UsuarioModel
    private BeanPropertyRowMapper<ArtesaoModel> rowMapper = new BeanPropertyRowMapper<ArtesaoModel>(ArtesaoModel.class);


    @Override
    public int save(ArtesaoModel artesaoModel) {
        String sql = "INSERT INTO artesao(usuario_cpf) VALUES(?)";

        // Objeto para armazenar o ID gerado
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, artesaoModel.getUsuario_cpf());
            return ps;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            artesaoModel.setNumero_conta(generatedId.intValue());
        }

        return 1;
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
