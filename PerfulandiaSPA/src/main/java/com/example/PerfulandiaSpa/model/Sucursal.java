package com.example.PerfulandiaSpa.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="Sucursal")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sucursal {
    @Id
    private int id;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private int horaApertura;
    @Column(nullable = false)
    private int horaCierre;
}
