package com.example.bibliotecaDuocBDD.controller;

import com.example.bibliotecaDuocBDD.model.Cart;
import com.example.bibliotecaDuocBDD.model.Perfume;
import com.example.bibliotecaDuocBDD.services.CartService;
import com.example.bibliotecaDuocBDD.services.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")  // Ruta base para el carrito
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private PerfumeService perfumeService;

    // Ver el carrito
    @GetMapping
    public Cart viewCart() {
        return cartService.getCart();
    }

    // Agregar un perfume al carrito
    @PostMapping("/add")
    public String addToCart(@RequestParam int perfumeId, @RequestParam int quantity) {
        Perfume perfume = perfumeService.getPerfumeById(perfumeId);
        if (perfume != null) {
            cartService.addPerfumeToCart(perfume, quantity);
            return "Perfume añadido al carrito";
        } else {
            return "Perfume no encontrado";
        }
    }

    // Eliminar un perfume del carrito
    @DeleteMapping("/remove")
    public String removeFromCart(@RequestParam int perfumeId) {
        Perfume perfume = perfumeService.getPerfumeById(perfumeId);
        if (perfume != null) {
            cartService.removePerfumeFromCart(perfume);
            return "Perfume eliminado del carrito";
        } else {
            return "Perfume no encontrado";
        }
    }

    // Ver el total del carrito
    @GetMapping("/total")
    public double getCartTotal() {
        return cartService.getCartTotal();
    }

    // Vaciar el carrito
    @DeleteMapping("/empty")
    public String emptyCart() {
        cartService.emptyCart();
        return "Carrito vaciado";
    }
}