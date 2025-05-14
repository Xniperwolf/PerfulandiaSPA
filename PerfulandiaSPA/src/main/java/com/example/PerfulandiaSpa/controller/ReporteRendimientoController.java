package com.example.PerfulandiaSpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Crear un reporte de rendimiento
    @PostMapping
    public ResponseEntity<ReporteRendimiento> createReporteR(@RequestBody ReporteRendimiento rendimiento) {
        try {
            ReporteRendimiento reporte = reporteRendimientoService.guardar(rendimiento);
            return ResponseEntity.status(HttpStatus.CREATED).body(reporte);
        } catch (Exception e) {
            // Manejo de excepciones (si ocurre algún error durante el guardado)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
