package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.Venta;
import com.example.PerfulandiaSpa.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas() {
        List<Venta> ventas = ventaService.getAllVentas();
        if (ventas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
        try {
            Venta venta = ventaService.getVentaById(id);
            return ResponseEntity.ok(venta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
        Venta saved = ventaService.saveVenta(venta);
        return ResponseEntity.status(201).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVenta(@PathVariable Long id) {
        try {
            ventaService.deleteVenta(id);
            return ResponseEntity.ok("Venta eliminada exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Venta no encontrada con ID: " + id);
        }
    }
}