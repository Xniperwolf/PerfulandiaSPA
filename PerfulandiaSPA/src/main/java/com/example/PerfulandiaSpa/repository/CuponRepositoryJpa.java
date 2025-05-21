package com.example.PerfulandiaSpa.repository;

import com.example.PerfulandiaSpa.model.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuponRepositoryJpa extends JpaRepository<Cupon, Long> {
    // Métodos personalizados si los necesitas
}