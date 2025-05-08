package com.example.bibliotecaDuocBDD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bibliotecaDuocBDD.model.ReporteRendimiento;

public interface ReporteRendimientoRepositoryJPA extends JpaRepository<ReporteRendimiento, Long> {

    // Método para encontrar un perfume por su ID
    ReporteRendimiento findById(int id);

    // Método para eliminar un perfume por su ID
    void deleteById(int id);
    
}
