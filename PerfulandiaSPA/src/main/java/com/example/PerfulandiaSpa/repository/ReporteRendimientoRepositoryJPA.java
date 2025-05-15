package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.ReporteRendimiento;

public interface ReporteRendimientoRepositoryJPA extends 
JpaRepository<ReporteRendimiento, String> {
    // JpaRepository already provides methods like save(), findById(), and deleteById()
    // No need to declare findById or deleteById
}