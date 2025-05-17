package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.PerfulandiaSpa.model.ReporteRendimiento;
import org.springframework.stereotype.Repository;

@Repository
public class ReporteRendimientoRepository {
    private final List<ReporteRendimiento> listaRrendimiento = new ArrayList<>();

    public ReporteRendimiento guardar(ReporteRendimiento rendimiento) {
        listaRrendimiento.add(rendimiento);
        return rendimiento;
    }

    public List<ReporteRendimiento> listar() {
        return Collections.unmodifiableList(listaRrendimiento);
    }

    public Optional<ReporteRendimiento> buscarPorId(String id) {
        return listaRrendimiento.stream()
                .filter(rep -> rep.getIdSucursal() == id)
                .findFirst();
    }

    public void eliminar(String id) {
        listaRrendimiento.removeIf(rep -> rep.getIdSucursal() == id);
    }
}