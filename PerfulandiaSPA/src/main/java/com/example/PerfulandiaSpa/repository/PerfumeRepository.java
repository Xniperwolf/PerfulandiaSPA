package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.Perfume;
import java.util.Optional;

public interface PerfumeRepository extends JpaRepository<Perfume, Integer> {
    // No es necesario definir métodos como obtenerPerfumes(), buscarPorId(), guardar() o actualizar(),
    // ya que JpaRepository ya proporciona esos métodos por defecto.

    // Buscar un perfume por su ID (ya proporcionado por JpaRepository como findById)
    Optional<Perfume> findById(int id);

    // Eliminar un perfume por su ID (ya proporcionado por JpaRepository como deleteById)
    void deleteById(int id);
}
