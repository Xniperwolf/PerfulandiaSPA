package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.Carrito;
import com.example.PerfulandiaSpa.model.ItemCarrito;
import com.example.PerfulandiaSpa.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @PostMapping("/{usuarioId}/agregar")
    public ResponseEntity<Carrito> agregarItem(@PathVariable Long Id, @PathVariable Long usuarioId, @RequestBody ItemCarrito item) {
        Carrito carrito = carritoService.agregarItem(Id,usuarioId, item);
        return ResponseEntity.ok(carrito);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Carrito> obtenerCarrito(@PathVariable Long usuarioId) {
        return carritoService.obtenerCarrito(usuarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{usuarioId}/vaciar")
    public ResponseEntity<Void> vaciarCarrito(@PathVariable Long usuarioId) {
        carritoService.vaciarCarrito(usuarioId);
        return ResponseEntity.noContent().build();
    }
}