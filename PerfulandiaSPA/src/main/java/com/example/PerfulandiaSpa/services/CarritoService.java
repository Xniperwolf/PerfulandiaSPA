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

    public Carrito agregarItem(Carrito carrito, ItemCarrito item) {
        Optional<Carrito> carritoOpt = carritoRepository.findByUsuarioId(carrito.getUsuario().getId());
        Carrito carritoExistente = carritoOpt.orElse(new Carrito());
        carritoExistente.getItems().add(item);
        return carritoRepository.save(carritoExistente);
    }

    public Optional<Carrito> obtenerCarrito(Long usuarioId) {
        return carritoRepository.findByUsuarioId(usuarioId);
    }

    public void vaciarCarrito(Long usuarioId) {
        Optional<Carrito> carritoOpt = carritoRepository.findByUsuarioId(usuarioId);
        carritoOpt.ifPresent(carrito -> carritoRepository.deleteByUsuarioId(carrito.getId()));
    }
}