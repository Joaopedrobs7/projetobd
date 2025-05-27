package com.example.projetobd.dao.cliente;


import com.example.projetobd.model.cliente.ClienteModel;
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
public class ClienteDaoImpl implements ClienteDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Mapeia a consulta para a entidade UsuarioModel
    private BeanPropertyRowMapper<ClienteModel> rowMapper = new BeanPropertyRowMapper<ClienteModel>(ClienteModel.class);


    @Override
    public int save(ClienteModel cliente) {
        String sql = "INSERT INTO cliente(usuario_cpf) VALUES(?)";

        // Objeto para armazenar o ID gerado
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getUsuario_cpf());
            return ps;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            cliente.setNumero_conta(generatedId.intValue());
        }

        return 1;


    }


    @Override
    public List<ClienteModel> getAll() {
        return jdbcTemplate.query("SELECT * FROM cliente",rowMapper);
    }

    @Override
    public ClienteModel getById(int numero_conta) {
        return jdbcTemplate.queryForObject("SELECT * FROM cliente WHERE numero_conta=?",rowMapper,numero_conta);
    }
}
