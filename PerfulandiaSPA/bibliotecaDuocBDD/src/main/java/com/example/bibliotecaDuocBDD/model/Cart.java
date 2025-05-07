package com.example.bibliotecaDuocBDD.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cart {

    private Map<Perfume, Integer> items = new HashMap<>();

    // Añadir un perfume al carrito
    public void addItem(Perfume perfume, int quantity) {
        if (items.containsKey(perfume)) {
            items.put(perfume, items.get(perfume) + quantity); // Si ya existe, aumentamos la cantidad
        } else {
            items.put(perfume, quantity); // Si no, agregamos el perfume con la cantidad indicada
        }
    }

    // Eliminar un perfume del carrito
    public void removeItem(Perfume perfume) {
        items.remove(perfume);
    }

    // Obtener el total de la compra
    public double getTotal() {
        double total = 0;
        for (Map.Entry<Perfume, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue(); // Multiplicamos el precio por la cantidad
        }
        return total;
    }

    // Verificar si el carrito está vacío
    public boolean isEmpty() {
        return items.isEmpty();
    }
}