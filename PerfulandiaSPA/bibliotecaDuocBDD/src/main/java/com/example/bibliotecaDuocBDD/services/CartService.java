package com.example.bibliotecaDuocBDD.services;

import org.springframework.stereotype.Service;
import com.example.bibliotecaDuocBDD.model.Cart;
import com.example.bibliotecaDuocBDD.model.Perfume;

@Service
public class CartService {

    private Cart cart = new Cart(); // Carrito en memoria (puedes modificarlo para usar sesiones o base de datos)

    // Agregar un perfume al carrito
    public void addPerfumeToCart(Perfume perfume, int quantity) {
        cart.addItem(perfume, quantity);
    }

    // Eliminar un perfume del carrito
    public void removePerfumeFromCart(Perfume perfume) {
        cart.removeItem(perfume);
    }

    // Obtener el carrito completo
    public Cart getCart() {
        return cart;
    }

    // Calcular el total
    public double getCartTotal() {
        return cart.getTotal();
    }

    // Vaciar el carrito
    public void emptyCart() {
        cart = new Cart(); // Reinicia el carrito
    }

    // Verificar si el carrito está vacío
    public boolean isCartEmpty() {
        return cart.isEmpty();
    }
}