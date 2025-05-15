package com.example.PerfulandiaSpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="provedor")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Provedor {
    @Id
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String contacto;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String direccion;


}
