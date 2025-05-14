package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PerfulandiaSpa.model.Producto;


public interface ProdictoRepositoryJpa extends JpaRepository<Producto, Integer> {

    // Método para encontrar un perfume por su ID
    Producto findById(int id);

    // Método para eliminar un perfume por su ID
    void deleteById(int id);
}
