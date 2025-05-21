// filepath: [ReporteInventarioService.java](http://_vscodecontentref_/3)
package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.ReporteInventario;
import com.example.PerfulandiaSpa.repository.ReporteInventarioRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteInventarioService {

    @Autowired
    private ReporteInventarioRepositoryJpa reporteInventarioRepository;

    public ReporteInventario saveReporteInventario(ReporteInventario inventario) {
        return reporteInventarioRepository.save(inventario);
    }

    public List<ReporteInventario> getAllReportesInventario() {
        return reporteInventarioRepository.findAll();
    }

    public void deleteReporteInventario(String id) {
        reporteInventarioRepository.deleteById(id);
    }
}