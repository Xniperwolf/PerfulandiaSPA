// filepath: [VentaService.java](http://_vscodecontentref_/2)
package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.Venta;
import com.example.PerfulandiaSpa.repository.VentaRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class VentaService {

    @Autowired
    private VentaRepositoryJpa ventaRepository;

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));
    }

    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}
