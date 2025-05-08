package com.example.bibliotecaDuocBDD.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaDuocBDD.model.ReporteInventario;

import com.example.bibliotecaDuocBDD.repository.ReporteInventraioRepositoryJPA;

@Service
public class ReporteInventarioService {
    @Autowired
    private ReporteInventraioRepositoryJPA reporteInventario;
    
    public ReporteInventario guardar(ReporteInventario inventario) {
        return reporteInventario.save(inventario);
    }
    
}
