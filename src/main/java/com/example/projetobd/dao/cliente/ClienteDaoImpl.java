package com.example.projetobd.dao.cliente;


import com.example.projetobd.model.cliente.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteDaoImpl implements ClienteDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Mapeia a consulta para a entidade UsuarioModel
    private BeanPropertyRowMapper<ClienteModel> rowMapper = new BeanPropertyRowMapper<ClienteModel>(ClienteModel.class);


    @Override
    public int save(ClienteModel cliente) {
        return jdbcTemplate.update("INSERT INTO cliente(usuario_cpf) VALUES(?)",
        cliente.getUsuario_cpf());

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
