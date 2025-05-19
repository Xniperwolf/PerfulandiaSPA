package com.example.PerfulandiaSpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrito {
    private int productoId;
    private int cantidad;
}