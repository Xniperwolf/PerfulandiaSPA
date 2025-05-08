package com.example.perfulandia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.perfulandia.Model.Producto;


public interface ProdictoRepositoryJpa extends JpaRepository<Producto, Long> {

    // Método para encontrar un perfume por su ID
    Producto findById(int id);

    // Método para eliminar un perfume por su ID
    void deleteById(int id);
}
