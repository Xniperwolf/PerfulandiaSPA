package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.PerfulandiaSpa.model.ReporteInventario;


public class ReporteInventarioRepository {
    private List<ReporteInventario> listaRInventario = new ArrayList<>();
    
    public ReporteInventario guardar(ReporteInventario inventario) {
        listaRInventario.add(inventario);
        return inventario;
    }
}
