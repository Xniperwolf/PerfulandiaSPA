// filepath: [ReporteRendimientoService.java](http://_vscodecontentref_/4)
package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.ReporteRendimiento;
import com.example.PerfulandiaSpa.repository.ReporteRendimientoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteRendimientoService {

    @Autowired
    private ReporteRendimientoRepositoryJpa reporteRendimientoRepository;

    public ReporteRendimiento saveReporteRendimiento(ReporteRendimiento rendimiento) {
        return reporteRendimientoRepository.save(rendimiento);
    }

    public List<ReporteRendimiento> getAllReportesRendimiento() {
        return reporteRendimientoRepository.findAll();
    }

    public void deleteReporteRendimiento(String id) {
        reporteRendimientoRepository.deleteById(id);
    }
}