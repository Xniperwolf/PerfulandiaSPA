package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.Venta;
import com.example.PerfulandiaSpa.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    // Obtener todas las ventas
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    // Obtener venta por ID
    public ResponseEntity<Venta> getVentaById(Long id) {
        Optional<Venta> venta = ventaRepository.findById(id);
        return venta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva venta
    public Venta createVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Eliminar una venta
    public ResponseEntity<Void> deleteVenta(Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
