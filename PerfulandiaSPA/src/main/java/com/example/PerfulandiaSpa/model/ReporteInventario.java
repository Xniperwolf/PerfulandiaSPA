package com.example.PerfulandiaSpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="reporte_inventario")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteInventario {
    @Id
    private String idProducto; 
    @Column(nullable = false)   
    private String nombreProducto;
    @Column(nullable = false)
    private int cantidadDisponible; 
    @Column(nullable = false)
    private double precioCompra;   
    @Column(nullable = false)
    private double precioVenta;    
    @Column(nullable = false)
    private String estado;
}
