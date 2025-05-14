package com.example.PerfulandiaSpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PerfulandiaSpa.model.ReporteInventario;

import com.example.PerfulandiaSpa.repository.ReporteInventarioRepositoryJPA;

@Service
public class ReporteInventarioService {
    @Autowired
    private ReporteInventarioRepositoryJPA reporteInventario;
    
    public ReporteInventario guardar(ReporteInventario inventario) {
        return reporteInventario.save(inventario);
    }
    
}
