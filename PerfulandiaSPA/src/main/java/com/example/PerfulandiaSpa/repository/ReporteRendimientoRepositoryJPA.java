package com.example.PerfulandiaSpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.ReporteRendimiento;

public interface ReporteRendimientoRepositoryJpa extends JpaRepository<ReporteRendimiento, Long> {
    // Métodos personalizados si los necesitas
}