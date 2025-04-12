package com.example.projetobd.dao;

import com.example.projetobd.model.produtoModel;
import com.example.projetobd.model.usuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class produtoDaoImpl implements produtoDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Mapeia a consulta para a entidade UsuarioModel
    private BeanPropertyRowMapper<produtoModel> rowMapper = new BeanPropertyRowMapper<produtoModel>(produtoModel.class);

    @Override
    public void save(produtoModel produto) {
        jdbcTemplate.update("INSERT INTO produto(loja_id,nome,preco,foto,estoque) VALUES(?,?,?,?,?)",
                produto.getLoja_id(),produto.getNome(),produto.getPreco(),produto.getFoto(),produto.getEstoque());
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
