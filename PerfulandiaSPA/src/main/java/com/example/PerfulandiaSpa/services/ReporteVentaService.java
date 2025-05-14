package com.example.PerfulandiaSpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PerfulandiaSpa.model.ReporteVenta;
import com.example.PerfulandiaSpa.repository.ReporteVentaRepositoryJPA;

@Service
public class ReporteVentaService {
    @Autowired
    private ReporteVentaRepositoryJPA reporteVentaRepository;

    public ReporteVenta saveReporteVenta(ReporteVenta venta) {
        return reporteVentaRepository.save(venta);
    }
}
