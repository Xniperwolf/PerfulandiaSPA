package com.example.perfulandia.Model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    private int id;
    @Column(nullable = false)
    private List<Producto> productos;
    @Column(nullable = false)
    private int fechaCreacion;
    @Column(nullable = false)
    private String estado;
}
