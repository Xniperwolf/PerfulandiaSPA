package com.example.PerfulandiaSpa.repository;

import java.util.stream.IntStream;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.ReporteRendimiento;

public interface ReporteRendimientoRepositoryJpa extends JpaRepository<ReporteRendimiento, String> {
    // Métodos personalizados si los necesitas
}