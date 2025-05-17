package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.PerfulandiaSpa.model.ReporteVenta;
import com.example.PerfulandiaSpa.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class ReporteVentaRepository {

    private final List<ReporteVenta> listaRventas = new ArrayList<>();

    // Método para guardar un reporte de venta con la información de un usuario
    public ReporteVenta guardar(ReporteVenta venta, Usuario usr) {
        if (usr == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        venta.setRutCliente(String.valueOf(usr.getId()));
        listaRventas.add(venta);
        return venta;
    }

    // Método para obtener todos los reportes de ventas
    public List<ReporteVenta> obtenerReportes() {
        return Collections.unmodifiableList(listaRventas);
    }
}