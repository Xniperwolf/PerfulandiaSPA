package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.Provedor;

public interface ProvedorRepositoryJpa extends JpaRepository<Provedor, Integer> {
    // Métodos personalizados si los necesitas
}