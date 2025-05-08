package com.example.bibliotecaDuocBDD.repository.ReporteVentas;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bibliotecaDuocBDD.model.ReporteVenta;

public interface ReporteVentaRepositoryJPA extends JpaRepository<ReporteVenta, Long> {

    // Método para encontrar un perfume por su ID
    ReporteVenta findById(int id);

    // Método para eliminar un perfume por su ID
    void deleteById(int id);
}