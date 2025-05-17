package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.Sucursal;
import com.example.PerfulandiaSpa.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<Sucursal>> getAllSucursales() {
        List<Sucursal> sucursales = sucursalService.getAllSucursales();
        if (sucursales.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sucursales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getSucursalById(@PathVariable Long id) {
        try {
            Sucursal sucursal = sucursalService.getSucursalById(id);
            return ResponseEntity.ok(sucursal);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Sucursal> createSucursal(@RequestBody Sucursal sucursal) {
        Sucursal saved = sucursalService.saveSucursal(sucursal);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> updateSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        try {
            Sucursal existing = sucursalService.getSucursalById(id);
            existing.setNombre(sucursal.getNombre());
            existing.setDireccion(sucursal.getDireccion());
            Sucursal updated = sucursalService.saveSucursal(existing);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSucursal(@PathVariable Long id) {
        try {
            sucursalService.deleteSucursal(id);
            return ResponseEntity.ok("Sucursal eliminada exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sucursal no encontrada con ID: " + id);
        }
    }
}