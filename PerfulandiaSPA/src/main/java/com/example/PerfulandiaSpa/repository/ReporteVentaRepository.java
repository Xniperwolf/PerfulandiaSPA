package com.example.bibliotecaDuocBDD.repository.ReporteVentas;

import java.util.ArrayList;
import java.util.List;


import com.example.bibliotecaDuocBDD.model.ReporteVenta;

public class ReporteVentaRepository {
    private List<ReporteVenta> listaRventas = new ArrayList<>();

    
    public ReporteVenta guardar(ReporteVenta venta) {
        listaRventas.add(venta);
        return venta;
    }
}
