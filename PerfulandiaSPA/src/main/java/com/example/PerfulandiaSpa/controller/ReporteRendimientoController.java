package com.example.bibliotecaDuocBDD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaDuocBDD.model.ReporteRendimiento;
import com.example.bibliotecaDuocBDD.services.ReporteRendimientoService;

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
