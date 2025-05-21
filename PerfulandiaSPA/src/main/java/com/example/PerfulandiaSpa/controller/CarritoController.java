package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.Carrito;
import com.example.PerfulandiaSpa.model.ItemCarrito;
import com.example.PerfulandiaSpa.model.Usuario;
import com.example.PerfulandiaSpa.services.CarritoService;
import com.example.PerfulandiaSpa.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/{usuarioId}/agregar")
    public ResponseEntity<Carrito> agregarItem(@PathVariable Long usuarioId, @RequestBody ItemCarrito item) {
        Carrito carrito = carritoService.obtenerCarrito(usuarioId).orElse(new Carrito());
        Usuario usuario = usuarioService.getUsuarioById(usuarioId);
        carrito.setUsuario(usuario);
        Carrito updatedCarrito = carritoService.agregarItem(carrito, item, usuario);
        return ResponseEntity.ok(updatedCarrito);
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