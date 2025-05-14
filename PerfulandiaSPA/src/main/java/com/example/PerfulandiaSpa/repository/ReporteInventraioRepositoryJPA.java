package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PerfulandiaSpa.model.ReporteInventario;

public interface ReporteInventraioRepositoryJPA extends JpaRepository<ReporteInventario, String> {

    // Método para encontrar un perfume por su ID
    ReporteInventario findById(int id);

    // Método para eliminar un perfume por su ID
    void deleteById(int id);
    
}
