package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.Carrito;
import com.example.PerfulandiaSpa.model.ItemCarrito;
import com.example.PerfulandiaSpa.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public Carrito agregarItem(Long usuarioId, ItemCarrito item) {
        Carrito carrito = carritoRepository.findByUsuarioId(usuarioId).orElse(new Carrito(usuarioId, new java.util.ArrayList<>()));
        carrito.getItems().add(item);
        return carritoRepository.save(carrito);
    }

    public Optional<Carrito> obtenerCarrito(Long usuarioId) {
        return carritoRepository.findByUsuarioId(usuarioId);
    }

    public void vaciarCarrito(Long usuarioId) {
        carritoRepository.delete(usuarioId);
    }
}