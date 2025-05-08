package com.example.perfulandia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.perfulandia.Model.Producto;
import com.example.perfulandia.Service.ProductoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/v1/Producto")
public class ProductoController {
    @Autowired
    private ProductoService prodService;

    @GetMapping()
    public ResponseEntity <List<Producto>> listaProductos() {
        List<Producto> productos =prodService.getProducto();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }
    @PostMapping("path")
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto prod) {
        Producto producto=prodService.saveProducto(prod);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }
    @GetMapping("{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable int id) {
        try {
            Producto prod=prodService.getProductoById(id);
            return ResponseEntity.ok(prod);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto prod) {
        
        try {
            Producto producto = prodService.getProductoById(id);
            producto.setCategoria(prod.getCategoria());
            producto.setEstado(prod.getEstado());
            producto.setNombre(prod.getNombre());
            producto.setPrecio(prod.getPrecio());
            producto.setStock_total(prod.getStock_total());
            prodService.saveProducto(producto);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id){
        try {
            prodService.deleteProducto(id);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    

}
