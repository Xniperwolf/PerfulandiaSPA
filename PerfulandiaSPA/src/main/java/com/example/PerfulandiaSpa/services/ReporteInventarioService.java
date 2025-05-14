package com.example.PerfulandiaSpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PerfulandiaSpa.model.ReporteInventario;

import com.example.PerfulandiaSpa.repository.ReporteInventraioRepositoryJPA;

@Service
public class ReporteInventarioService {
    @Autowired
    private ReporteInventraioRepositoryJPA reporteInventario;
    
    public ReporteInventario guardar(ReporteInventario inventario) {
        return reporteInventario.save(inventario);
    }
    
}
