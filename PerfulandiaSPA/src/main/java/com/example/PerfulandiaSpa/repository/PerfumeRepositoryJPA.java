package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.Perfume;

public interface PerfumeRepositoryJPA extends JpaRepository<Perfume, Long> {

    // Método para encontrar un perfume por su ID
    Perfume findById(int id);

    // Método para eliminar un perfume por su ID
    void deleteById(int id);
}