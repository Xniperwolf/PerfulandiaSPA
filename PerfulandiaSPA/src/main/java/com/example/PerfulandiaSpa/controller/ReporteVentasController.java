package com.example.bibliotecaDuocBDD.controller.ReporteVentas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaDuocBDD.model.ReporteVenta;
import com.example.bibliotecaDuocBDD.services.ReporteVentaService;

@RestController
@RequestMapping("/api/v1/ReporteVentas")
public class ReporteVentasController {
    @Autowired
    private ReporteVentaService reporteVentasService;
        @PostMapping
    public ReporteVenta createReporteV(@RequestBody ReporteVenta venta) {
        return reporteVentasService.savereporteVenta(venta);
    }
}
