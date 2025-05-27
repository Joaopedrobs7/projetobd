package com.example.projetobd.dao.produtoCompra;

import com.example.projetobd.model.produtoCompra.ProdutoCompraModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProdutoCompraDaoImpl implements  ProdutoCompraDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    //Row mapper
    private BeanPropertyRowMapper<ProdutoCompraModel> rowMapper = new BeanPropertyRowMapper<ProdutoCompraModel>(ProdutoCompraModel.class);


    @Override
    public int save(ProdutoCompraModel produtoCompraModel) {
        return jdbcTemplate.update("INSERT INTO produto_compra(num_compra,cod_produto,qtd) VALUES(?,?,?)",produtoCompraModel.getNum_compra(),produtoCompraModel.getCod_produto(),produtoCompraModel.getQtd());
    }

    @Override
    public List<ProdutoCompraModel> findByCompraId(int compra_id) {
        return jdbcTemplate.query("SELECT * FROM produto_compra WHERE num_compra=?",rowMapper,compra_id);
    }

    @Override
    public List<ProdutoCompraModel> findall() {
        return jdbcTemplate.query("SELECT * FROM produto_compra",rowMapper);
    }
}
