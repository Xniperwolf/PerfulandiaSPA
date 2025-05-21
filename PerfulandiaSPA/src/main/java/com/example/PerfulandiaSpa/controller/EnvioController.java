package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.Envio;
import com.example.PerfulandiaSpa.services.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public ResponseEntity<List<Envio>> getAllEnvios() {
        List<Envio> envios = envioService.getAllEnvios();
        if (envios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(envios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envio> getEnvioById(@PathVariable int id) {
        try {
            Envio envio = envioService.getEnvioById(id);
            return ResponseEntity.ok(envio);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Envio> createEnvio(@RequestBody Envio envio) {
        Envio saved = envioService.saveEnvio(envio);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Envio> updateEnvio(@PathVariable int id, @RequestBody Envio envio) {
        try {
            Envio existing = envioService.getEnvioById(id);
            existing.setEstado(envio.getEstado());
            existing.setDestino(envio.getDestino());
            existing.setOrigen(envio.getOrigen());
            existing.setDetalles(envio.getDetalles());
            existing.setFechaEnvio(envio.getFechaEnvio());
            existing.setFechaRecepcion(envio.getFechaRecepcion());
            Envio updated = envioService.saveEnvio(existing);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnvio(@PathVariable int id) {
        try {
            envioService.deleteEnvio(id);
            return ResponseEntity.ok("Envio eliminado exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Envio no encontrado con ID: " + id);
        }
    }
}