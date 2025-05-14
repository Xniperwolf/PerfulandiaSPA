package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.PerfulandiaSpa.model.ReporteRendimiento;


public class ReporteRendimientoRepository {
    private List<ReporteRendimiento> listaRrendimiento = new ArrayList<>();

    
    public ReporteRendimiento guardar(ReporteRendimiento rendimiento) {
        listaRrendimiento.add(rendimiento);
        return rendimiento;
    }
}