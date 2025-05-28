package com.example.projetobd.controller.report;

import com.example.projetobd.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/reports") // Um novo endpoint dedicado para relatórios
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/dashboard-stats")
    public Map<String, Integer> getDashboardStats() {
        return reportService.getDashboardStats();
    }
}