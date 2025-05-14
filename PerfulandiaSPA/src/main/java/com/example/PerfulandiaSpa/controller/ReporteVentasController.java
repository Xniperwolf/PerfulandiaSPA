package com.example.PerfulandiaSpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PerfulandiaSpa.model.ReporteVenta;
import com.example.PerfulandiaSpa.services.ReporteVentaService;

@RestController
@RequestMapping("/api/v1/ReporteVentas")
public class ReporteVentasController {

    @Autowired
    private ReporteVentaService reporteVentasService;

    // Crear un reporte de venta
    @PostMapping
    public ResponseEntity<ReporteVenta> createReporteV(@RequestBody ReporteVenta venta) {
        try {
            // Guardar el reporte de venta
            ReporteVenta reporte = reporteVentasService.saveReporteVenta(venta);
            // Retornar respuesta exitosa con el reporte creado
            return ResponseEntity.status(HttpStatus.CREATED).body(reporte);
        } catch (Exception e) {
            // Manejo de excepciones (si ocurre algún error durante el guardado)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
