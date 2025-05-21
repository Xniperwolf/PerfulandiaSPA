package com.example.PerfulandiaSpa.repository;

import com.example.PerfulandiaSpa.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepositoryJpa extends JpaRepository<Venta, Long> {
    // Métodos personalizados si los necesitas
}