package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.Producto;

public interface ProductoRepositoryJpa extends JpaRepository<Producto, Integer> {
    // No need for custom findById_producto, use JpaRepository's findById(int id)
}