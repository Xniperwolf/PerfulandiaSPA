package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.ReporteVenta;
import com.example.PerfulandiaSpa.services.ReporteVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reporte-ventas")
public class ReporteVentasController {

    @Autowired
    private ReporteVentaService reporteVentaService;

    @PostMapping
    public ResponseEntity<ReporteVenta> createReporteVenta(@RequestBody ReporteVenta venta) {
        try {
            ReporteVenta reporte = reporteVentaService.saveReporteVenta(venta);
            return ResponseEntity.status(HttpStatus.CREATED).body(reporte);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<ReporteVenta>> getAllReportesVenta() {
        List<ReporteVenta> reportes = reporteVentaService.getAllReportesVenta();
        if (reportes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reportes);
    }
}