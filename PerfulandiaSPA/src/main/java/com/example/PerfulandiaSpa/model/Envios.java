package com.example.PerfulandiaSpa.Model;

import java.util.List;

import com.example.gestionenvios.model.Producto; // Asegúrate de que la ruta a Producto sea correcta
import com.example.gestionenvios.model.Sucursal; // Asegúrate de que la ruta a Sucursal sea correcta

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Envios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Envios {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", nullable = false) // Asumo que tienes un ID para Sucursal
    private Sucursal sucursal;

    @ManyToMany
    @JoinTable(
        name = "envio_producto",
        joinColumns = @JoinColumn(name = "envio_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;
}