package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.ReporteRendimiento;
import com.example.PerfulandiaSpa.services.ReporteRendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reporte-rendimiento")
public class ReporteRendimientoController {

    @Autowired
    private ReporteRendimientoService reporteRendimientoService;

    @PostMapping
    public ResponseEntity<ReporteRendimiento> createReporteRendimiento(@RequestBody ReporteRendimiento rendimiento) {
        try {
            ReporteRendimiento reporte = reporteRendimientoService.saveReporteRendimiento(rendimiento);
            return ResponseEntity.status(HttpStatus.CREATED).body(reporte);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<ReporteRendimiento>> getAllReportesRendimiento() {
        List<ReporteRendimiento> reportes = reporteRendimientoService.getAllReportesRendimiento();
        if (reportes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reportes);
    }
}