package com.example.PerfulandiaSpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="reporte_rendimiento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteRendimiento {
    @Id
    private String idSucursal;        
    @Column(nullable = false)
    private String nombreSucursal;
    @Column(nullable = false)   
    private double ventasTotales;
    @Column(nullable = false)     
    private double metasCumplidas;    
    @Column(nullable = false)
    private double ganancias; 
    @Column(nullable = false)        
    private int empleados;   
    @Column(nullable = false)          
    private String periodo;   
}
