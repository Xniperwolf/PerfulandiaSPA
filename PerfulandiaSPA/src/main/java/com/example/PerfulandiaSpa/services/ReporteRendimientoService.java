package com.example.PerfulandiaSpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PerfulandiaSpa.model.ReporteRendimiento;
import com.example.PerfulandiaSpa.repository.ReporteRendimientoRepositoryJPA;


@Service
public class ReporteRendimientoService {
    @Autowired
    private ReporteRendimientoRepositoryJPA reporteRendimineto;

    public ReporteRendimiento guardar(ReporteRendimiento rendimiento) {
        return reporteRendimineto.save(rendimiento);
    }
}
