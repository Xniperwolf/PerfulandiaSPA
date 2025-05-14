package com.example.PerfulandiaSpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PerfulandiaSpa.model.ReporteVenta;
import com.example.PerfulandiaSpa.services.ReporteVentaService;




@RestController
@RequestMapping("/api/v1/ReporteVentas")
public class ReporteVentasController {
    @Autowired
    private ReporteVentaService reporteVentasService;
        @PostMapping
    public ReporteVenta createReporteV(@RequestBody ReporteVenta venta) {
        return reporteVentasService.saveReporteVenta(venta);
    }
}
