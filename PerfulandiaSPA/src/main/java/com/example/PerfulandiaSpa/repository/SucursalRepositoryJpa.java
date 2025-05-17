package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.Sucursal;

public interface SucursalRepositoryJpa extends JpaRepository<Sucursal, Long> {
    // Métodos personalizados si los necesitas
}