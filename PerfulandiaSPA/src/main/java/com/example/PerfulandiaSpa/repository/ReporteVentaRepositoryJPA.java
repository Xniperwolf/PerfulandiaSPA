package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.ReporteVenta;

public interface ReporteVentaRepositoryJPA extends JpaRepository<ReporteVenta, String> {

    // Método para encontrar un perfume por su ID
    ReporteVenta findById(int id);

    // Método para eliminar un perfume por su ID
    void deleteById(int id);
}