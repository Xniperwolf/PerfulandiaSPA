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
@Table(name = "producto")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Producto {

    @Id
    public int id_producto;
    @Column(nullable= false,length = 50)
    public String nombre;
    @Column(nullable= false,length=50)
    public int precio;
    @Column(nullable=false,length=50)
    public int stock_total;
    @Column(nullable=false,length=50)
    public String categoria;
    @Column(nullable=false,length=50)
    public String estado;
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Provedor proveedor;

}
