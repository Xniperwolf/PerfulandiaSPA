package com.example.bibliotecaDuocBDD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaDuocBDD.model.ReporteInventario;
import com.example.bibliotecaDuocBDD.services.ReporteInventarioService;



@RestController
@RequestMapping("/api/v1/ReporteInventario")
public class ReporteInventarioController {
    @Autowired
    private ReporteInventarioService reporteInventarioService;
        @PostMapping
    public ReporteInventario createReporteI(@RequestBody ReporteInventario inventario) {
        return reporteInventarioService.guardar(inventario);
    }
}
