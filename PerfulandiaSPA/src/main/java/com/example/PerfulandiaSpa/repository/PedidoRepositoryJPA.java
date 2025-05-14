package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.PerfulandiaSpa.model.Pedido;

import java.util.Optional;

@Repository
public interface PedidoRepositoryJPA extends JpaRepository<Pedido, Integer> {
    // Encuentra un pedido por su ID (ya existe en JpaRepository, pero lo dejamos aquí para que veas cómo hacerlo)
    Optional<Pedido> findById(int id);

    // Otros métodos personalizados pueden ser agregados, por ejemplo:
    // List<Pedido> findByEstado(String estado);
    // List<Pedido> findByFechaCreacion(LocalDate fechaCreacion);
}
