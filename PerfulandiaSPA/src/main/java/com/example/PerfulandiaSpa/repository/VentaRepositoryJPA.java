package com.example.PerfulandiaSpa.repository;

import com.example.PerfulandiaSpa.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRepositoryJPA extends JpaRepository<Venta, Long> {

    // Método personalizado para encontrar ventas por cliente
    List<Venta> findByid(Long id);

    // Método personalizado para encontrar ventas dentro de un rango de fechas
    List<Venta> findByFechaBetween(LocalDateTime start, LocalDateTime end);
}
