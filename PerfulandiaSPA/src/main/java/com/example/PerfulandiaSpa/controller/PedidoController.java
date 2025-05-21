package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.Pedido;
import com.example.PerfulandiaSpa.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable int id) {
        try {
            Pedido pedido = pedidoService.getPedidoById(id);
            return ResponseEntity.ok(pedido);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Pedido>> getPedidosByUsuario(@PathVariable Pedido pedido) {
        List<Pedido> pedidos = pedidoService.getPedidosByUsuario(pedido.getUsuario());
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    // Buscar pedidos por sucursal
    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<Pedido>> getPedidosBySucursal(@PathVariable Pedido pedido) {
        List<Pedido> pedidos = pedidoService.getPedidosBySucursal(pedido.getSucursal());
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido saved = pedidoService.savePedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable int id, @RequestBody Pedido pedido) {
        try {
            Pedido existing = pedidoService.getPedidoById(id);
            existing.setEstado(pedido.getEstado());
            existing.setFechaCreacion(pedido.getFechaCreacion());
            existing.setProductos(pedido.getProductos());
            Pedido updated = pedidoService.savePedido(existing);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePedido(@PathVariable int id) {
        try {
            pedidoService.deletePedido(id);
            return ResponseEntity.ok("Pedido eliminado exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado con ID: " + id);
        }
    }
}