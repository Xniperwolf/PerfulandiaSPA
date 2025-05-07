package com.example.PerfulandiaSpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "perfume")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Perfume {
    @Id
    public int id;
    @Column(nullable = false)
    public String nombrePerfume;
    @Column(nullable = false, length = 50)
    public String marca;
    @Column(nullable = false)
    public int precio;
    @Column(nullable = false)
    public int fechaPublicacion;
}