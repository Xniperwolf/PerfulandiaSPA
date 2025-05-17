package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.Provedor;
import com.example.PerfulandiaSpa.services.ProvedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/provedores")
public class ProvedorController {

    @Autowired
    private ProvedorService provedorService;

    @GetMapping
    public ResponseEntity<List<Provedor>> getAllProvedores() {
        List<Provedor> provedores = provedorService.getAllProvedores();
        if (provedores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(provedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provedor> getProvedorById(@PathVariable int id) {
        try {
            Provedor provedor = provedorService.getProvedorById(id);
            return ResponseEntity.ok(provedor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Provedor> createProvedor(@RequestBody Provedor provedor) {
        Provedor saved = provedorService.saveProvedor(provedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Provedor> updateProvedor(@PathVariable int id, @RequestBody Provedor provedor) {
        try {
            Provedor existing = provedorService.getProvedorById(id);
            existing.setNombre(provedor.getNombre());
            existing.setDireccion(provedor.getDireccion());
            existing.setEmail(provedor.getEmail());
            existing.setTelefono(provedor.getTelefono());
            existing.setContacto(provedor.getContacto());
            Provedor updated = provedorService.saveProvedor(existing);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProvedor(@PathVariable int id) {
        try {
            provedorService.deleteProvedor(id);
            return ResponseEntity.ok("Provedor eliminado exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Provedor no encontrado con ID: " + id);
        }
    }
}