package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.Pedido;

public interface PedidoRepositoryJpa extends JpaRepository<Pedido, Integer> {
    // Métodos personalizados si los necesitas
}