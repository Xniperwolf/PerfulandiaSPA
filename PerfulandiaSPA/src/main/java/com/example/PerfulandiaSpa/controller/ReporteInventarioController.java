package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.ReporteInventario;
import com.example.PerfulandiaSpa.services.ReporteInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reporte-inventario")
public class ReporteInventarioController {

    @Autowired
    private ReporteInventarioService reporteInventarioService;

    @PostMapping
    public ResponseEntity<ReporteInventario> createReporteInventario(@RequestBody ReporteInventario inventario) {
        try {
            ReporteInventario reporte = reporteInventarioService.saveReporteInventario(inventario);
            return ResponseEntity.status(HttpStatus.CREATED).body(reporte);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<ReporteInventario>> getAllReportesInventario() {
        List<ReporteInventario> reportes = reporteInventarioService.getAllReportesInventario();
        if (reportes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reportes);
    }
}