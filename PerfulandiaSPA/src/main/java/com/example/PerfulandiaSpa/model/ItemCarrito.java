package com.example.PerfulandiaSpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ItemCarrito {
    private int productoId;
    private int cantidad;
}