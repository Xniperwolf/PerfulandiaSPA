package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.PerfulandiaSpa.model.ReporteVenta;
import com.example.PerfulandiaSpa.model.Usuario;

public class ReporteVentaRepository {
    
    private List<ReporteVenta> listaRventas = new ArrayList<>();
    
    // Método para guardar un reporte de venta con la información de un usuario
    public ReporteVenta guardar(ReporteVenta venta, Usuario usr) {
        // Asignar el rutCliente utilizando el id del usuario
        if (usr != null) {
            venta.setRutCliente(String.valueOf(usr.getId())); // Convertir el id de Usuario a String
        } else {
            // Manejar el caso de un usuario nulo, si es necesario
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        
        // Agregar el reporte de venta a la lista
        listaRventas.add(venta);
        
        // Retornar el objeto ReporteVenta con el rutCliente asignado
        return venta;
    }
    
    // Método para obtener todos los reportes de ventas
    public List<ReporteVenta> obtenerReportes() {
        return listaRventas;
    }
}
