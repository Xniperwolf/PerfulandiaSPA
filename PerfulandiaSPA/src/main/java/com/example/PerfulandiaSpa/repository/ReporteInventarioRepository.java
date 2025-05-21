package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.PerfulandiaSpa.model.ReporteInventario;
import org.springframework.stereotype.Repository;

@Repository
public class ReporteInventarioRepository {
    private final List<ReporteInventario> listaRInventario = new ArrayList<>();

    public ReporteInventario guardar(ReporteInventario inventario) {
        listaRInventario.add(inventario);
        return inventario;
    }

    public List<ReporteInventario> listar() {
        return Collections.unmodifiableList(listaRInventario);
    }

    public Optional<ReporteInventario> buscarPorId(String id) {
        return listaRInventario.stream()
                .filter(rep -> rep.getIdReporte() == id)
                .findFirst();
    }

    public void eliminar(String id) {
        listaRInventario.removeIf(rep -> rep.getIdReporte() == id);
    }
}