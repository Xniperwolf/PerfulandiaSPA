package com.example.PerfulandiaSpa.repository;

import com.example.PerfulandiaSpa.model.EnvioDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioDetalleRepositoryJpa extends JpaRepository<EnvioDetalle, Long> {
    // Métodos personalizados si los necesitas
}