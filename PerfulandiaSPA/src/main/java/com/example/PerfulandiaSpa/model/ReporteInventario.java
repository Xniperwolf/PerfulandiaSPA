package com.example.PerfulandiaSpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reporte_inventario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteInventario {

    @Id
    @Column(name = "id_reporte", unique = true, nullable = false) // Especificar columna con nombre exacto en la base de datos
    private String idReporte; // ID único para el reporte

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto; // Relación con la entidad Producto

    @Column(nullable = false)
    private int cantidadDisponible; // Cantidad disponible del producto en inventario

    @Column(nullable = false)
    private double precioCompra; // Precio de compra del producto

    @Column(nullable = false)
    private double precioVenta; // Precio de venta del producto

    @Column(nullable = false)
    private String estado; // Estado del producto en el inventario (disponible, agotado, etc.)
}
