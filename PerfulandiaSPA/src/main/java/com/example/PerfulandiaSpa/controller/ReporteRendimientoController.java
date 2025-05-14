package com.example.PerfulandiaSpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PerfulandiaSpa.model.ReporteRendimiento;
import com.example.PerfulandiaSpa.services.ReporteRendimientoService;

@RestController
@RequestMapping("/api/v1/ReporteRendimiento")
public class ReporteRendimientoController {
    @Autowired
    private ReporteRendimientoService reporteRendimientoService;
    @PostMapping
    public ReporteRendimiento createReporteR(@RequestBody ReporteRendimiento rendimiento) {
        return reporteRendimientoService.guardar(rendimiento);
    }
}
