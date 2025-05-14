package com.example.PerfulandiaSpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PerfulandiaSpa.model.ReporteInventario;
import com.example.PerfulandiaSpa.services.ReporteInventarioService;

@RestController
@RequestMapping("/api/v1/ReporteInventario")
public class ReporteInventarioController {

    @Autowired
    private ReporteInventarioService reporteInventarioService;

    // Crear un reporte de inventario
    @PostMapping
    public ResponseEntity<ReporteInventario> createReporteI(@RequestBody ReporteInventario inventario) {
        try {
            ReporteInventario reporte = reporteInventarioService.guardar(inventario);
            return ResponseEntity.status(HttpStatus.CREATED).body(reporte);
        } catch (Exception e) {
            // Manejo de excepciones (si ocurre algún error durante el guardado)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
