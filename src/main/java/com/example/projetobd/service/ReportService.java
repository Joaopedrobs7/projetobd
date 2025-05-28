package com.example.projetobd.service;

import com.example.projetobd.dao.report.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private ReportDao reportDao;

    public Map<String, Integer> getDashboardStats() {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("totalEncomendas", reportDao.getTotalEncomendas());
        stats.put("pendingEncomendas", reportDao.getPendingEncomendas());
        stats.put("totalProdutos", reportDao.getTotalProdutos());
        stats.put("totalCompras", reportDao.getTotalVendas());
        stats.put("totalClientes", reportDao.getTotalClientes()); // NOVO
        stats.put("totalArtesaos", reportDao.getTotalArtesaos()); // NOVO
        return stats;
    }
}