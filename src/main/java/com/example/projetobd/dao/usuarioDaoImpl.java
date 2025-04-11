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

    //Mapeia a consulta para a entidade UsuarioModel
    private BeanPropertyRowMapper<usuarioModel> rowMapper = new BeanPropertyRowMapper<usuarioModel>(usuarioModel.class);

    @Override
    public void save(usuarioModel usuario) {
         jdbcTemplate.update("INSERT INTO usuario(nome,cpf,tel_fixo,celular,dt_nascimento) VALUES(?,?,?,?,?)",
                usuario.getNome(),usuario.getCpf(),usuario.getTel_fixo(),usuario.getCelular(),usuario.getDt_nascimento());
    }

    @Override
    public int update(usuarioModel usuario, String cpf) {
        return jdbcTemplate.update("UPDATE usuario SET nome=?, tel_fixo=?, celular=?, dt_nascimento=? WHERE cpf=?",usuario.getNome(),usuario.getTel_fixo(),usuario.getCelular(),usuario.getDt_nascimento(),cpf);
    }

    @Override
    public int delete(String cpf) {
        return jdbcTemplate.update("DELETE FROM usuario WHERE cpf=?",cpf);
    }

    @Override
    public List<usuarioModel> getAll() {
        return jdbcTemplate.query("SELECT * FROM usuario", rowMapper);
    }

    @Override
    public usuarioModel getByCpf(String cpf) {
        return jdbcTemplate.queryForObject("SELECT * FROM usuario WHERE cpf = ?",rowMapper,cpf);
    }
}
