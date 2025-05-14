package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.ReporteVenta;

public interface ReporteVentaRepositoryJPA extends JpaRepository<ReporteVenta, String> {
    // Usa los métodos por defecto: findById(String idVenta), deleteById(String idVenta)
}