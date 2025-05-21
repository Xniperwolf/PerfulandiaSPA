package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PerfulandiaSpa.model.Carrito;

public interface CarritoRepositoryJpa extends JpaRepository<Carrito, Long> {
    // Este repositorio extiende JpaRepository para proporcionar operaciones CRUD
    // Métodos personalizados si los necesitas
    // Por ejemplo, puedes agregar métodos para buscar carritos por usuario, etc.
    
}
