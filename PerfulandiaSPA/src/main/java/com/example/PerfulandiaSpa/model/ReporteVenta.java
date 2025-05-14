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
@Table(name = "reporte_ventas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteVenta {

    @Id
    private String idVenta;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private int cantidadVendida;

    @Column(nullable = false)
    private int precioUnitario;

    @Column(nullable = false)
    private double totalVenta;

    @Column(nullable = false)
    private String fechaVenta;

    @Column(nullable = false)
    private String metodoPago;

    @Column(nullable = false)
    private String rutCliente;
}