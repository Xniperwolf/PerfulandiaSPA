package com.example.bibliotecaDuocBDD.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaDuocBDD.model.ReporteRendimiento;
import com.example.bibliotecaDuocBDD.repository.ReporteRendimientoRepositoryJPA;


@Service
public class ReporteRendimientoService {
    @Autowired
    private ReporteRendimientoRepositoryJPA reporteRendimineto;

    public ReporteRendimiento guardar(ReporteRendimiento rendimiento) {
        return reporteRendimineto.save(rendimiento);
    }
}
