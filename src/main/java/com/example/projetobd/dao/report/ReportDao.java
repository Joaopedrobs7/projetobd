package com.example.projetobd.dao.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getTotalEncomendas() {
        return jdbcTemplate.queryForObject("SELECT GetTotalEncomendas()", Integer.class);
    }

    public int getPendingEncomendas() {
        return jdbcTemplate.queryForObject("SELECT GetPendingEncomendas()", Integer.class);
    }

    public int getTotalProdutos() {
        return jdbcTemplate.queryForObject("SELECT GetTotalProdutos()", Integer.class);
    }

    public int getTotalVendas() {
        return jdbcTemplate.queryForObject("SELECT GetTotalVendas()", Integer.class);
    }

    public int getTotalClientes() { // NOVO
        return jdbcTemplate.queryForObject("SELECT GetTotalClientes()", Integer.class);
    }

    public int getTotalArtesaos() { // NOVO
        return jdbcTemplate.queryForObject("SELECT GetTotalArtesaos()", Integer.class);
    }

}