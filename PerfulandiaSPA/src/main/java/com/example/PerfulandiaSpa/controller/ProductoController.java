package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.Producto;
import com.example.PerfulandiaSpa.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productos = productoService.getAllProductos();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable int id) {
        try {
            Producto producto = productoService.getProductoById(id);
            return ResponseEntity.ok(producto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto saved = productoService.saveProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable int id, @RequestBody Producto producto) {
        try {
            Producto existing = productoService.getProductoById(id);
            existing.setNombre(producto.getNombre());
            existing.setCategoria(producto.getCategoria());
            existing.setEstado(producto.getEstado());
            existing.setPrecio(producto.getPrecio());
            existing.setStock_total(producto.getStock_total());
            Producto updated = productoService.saveProducto(existing);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable int id) {
        try {
            productoService.deleteProducto(id);
            return ResponseEntity.ok("Producto eliminado exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado con ID: " + id);
        }
    }
}