package com.example.PerfulandiaSpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrito {
    private Long usuarioId;
    private List<ItemCarrito> items = new ArrayList<>();
}