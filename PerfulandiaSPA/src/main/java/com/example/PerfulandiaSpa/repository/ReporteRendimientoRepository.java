package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.PerfulandiaSpa.model.ReporteRendimiento;
import com.example.PerfulandiaSpa.model.Sucursal;

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

    public Optional<ReporteRendimiento> buscarPorId(long id) {
        return listaRrendimiento.stream()
                .filter(rep -> rep.getId() == id)
                .findFirst();
    }

    public void eliminar(long id) {
        listaRrendimiento.removeIf(rep -> rep.getSucursal().getId() == id);
    }

     public List<ReporteRendimiento> findBySucursal(Sucursal sucursal) {
         List<ReporteRendimiento> resultados = new ArrayList<>();
         for (ReporteRendimiento rep : listaRrendimiento) {
             if (rep.getSucursal().equals(sucursal)) {
                 resultados.add(rep);
             }
         }
         return resultados;
     }
}