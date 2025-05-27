package com.example.projetobd.dao.produto;

import com.example.projetobd.model.produto.produtoModel;
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
public class produtoDaoImpl implements produtoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Mapeia a consulta para a entidade UsuarioModel
    private BeanPropertyRowMapper<produtoModel> rowMapper = new BeanPropertyRowMapper<produtoModel>(produtoModel.class);

    @Override
    public int save(produtoModel produto) {
        String sql = "INSERT INTO produto(loja_id,nome,preco,foto,estoque) VALUES(?,?,?,?,?)";

        // Objeto para armazenar o ID gerado
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, produto.getLoja_id());
            ps.setString(2, produto.getNome());
            ps.setInt(3, produto.getPreco());
            ps.setString(4, produto.getFoto());
            ps.setInt(5, produto.getEstoque());
            return ps;
        }, keyHolder);

        // Recupera o ID e define no modelo
        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            produto.setCod(generatedId.intValue());
        }

        return 1; // ou opcionalmente: return generatedId.intValue();

    }

    @Override
    public int update(produtoModel produto,int cod) {
        return jdbcTemplate.update("UPDATE produto SET nome=?, preco=?,foto=?,estoque=? WHERE cod=?", produto.getNome(),produto.getPreco(),produto.getFoto(),produto.getEstoque(),cod);
    }

    @Override
    public int delete(int cod) {
        return jdbcTemplate.update("DELETE FROM produto WHERE cod=?",cod);
    }

    @Override
    public List<produtoModel> getAll() {
        return jdbcTemplate.query("SELECT * FROM produto",rowMapper);
    }

    @Override
    public produtoModel getById(int cod) {
        return jdbcTemplate.queryForObject("SELECT * FROM produto WHERE cod=?",rowMapper,cod);
    }
}
