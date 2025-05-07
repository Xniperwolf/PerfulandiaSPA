package com.example.PerfulandiaSpa.repository;

import com.example.PerfulandiaSpa.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    // Aquí puedes agregar consultas personalizadas si es necesario
    // Ejemplo: List<Venta> findByClienteId(Long clienteId);
    // Ejemplo: List<Venta> findByFechaBetween(LocalDateTime start, LocalDateTime end);
}
