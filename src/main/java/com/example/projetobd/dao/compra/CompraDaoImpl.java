package com.example.projetobd.dao.compra;

import com.example.projetobd.model.compra.CompraModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class CompraDaoImpl implements CompraDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    //Rowmapper
    private BeanPropertyRowMapper<CompraModel> rowMapper = new BeanPropertyRowMapper<CompraModel>(CompraModel.class);


    @Override
    public int save(CompraModel compraModel) {
        AtomicReference<String> sql = new AtomicReference<>();
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int linhasAfetadas = jdbcTemplate.update(connection -> {
            PreparedStatement ps;

            if ("encomenda".equalsIgnoreCase(compraModel.getTipo_compra())) {
                sql.set("INSERT INTO compra (cliente_conta, tipo_compra, encomenda_id) VALUES (?, ?, ?)");
                ps = connection.prepareStatement(sql.get(), Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, compraModel.getCliente_conta());
                ps.setString(2, compraModel.getTipo_compra());
                ps.setInt(3, compraModel.getEncomenda_id());
            } else {
                sql.set("INSERT INTO compra (cliente_conta, tipo_compra) VALUES (?, ?)");
                ps = connection.prepareStatement(sql.get(), Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, compraModel.getCliente_conta());
                ps.setString(2, compraModel.getTipo_compra());
            }

            return ps;
        }, keyHolder);

        // Seta o id gerado no model
        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            compraModel.setNumero_compra(generatedId.intValue());
        }

        // Retorna 1 para indicar sucesso (como você quer)
        return compraModel.getNumero_compra();
    }



    @Override
    public CompraModel findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM compra WHERE numero_compra=?",rowMapper,id);
    }

    @Override
    public List<CompraModel> findall() {
        return jdbcTemplate.query("SELECT * FROM compra",rowMapper);
    }
}
