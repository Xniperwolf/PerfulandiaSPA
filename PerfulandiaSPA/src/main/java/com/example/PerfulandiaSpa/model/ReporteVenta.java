package com.example.bibliotecaDuocBDD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
        @Column(nullable = false)
        private String producto; 
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
}
