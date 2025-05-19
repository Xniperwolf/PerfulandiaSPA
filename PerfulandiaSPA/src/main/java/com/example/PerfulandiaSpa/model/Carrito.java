package com.example.PerfulandiaSpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carrito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrito {
    private Long id;
    private Long usuarioId;
    private List<ItemCarrito> items = new ArrayList<>();
}