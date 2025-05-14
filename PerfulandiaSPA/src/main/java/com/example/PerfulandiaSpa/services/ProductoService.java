package com.example.PerfulandiaSpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PerfulandiaSpa.model.Producto;
import com.example.PerfulandiaSpa.repository.ProductoRepositoryJpa;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepositoryJpa prodRepository;

    // Obtener todos los productos
    public List<Producto> getProducto() {
        return prodRepository.findAll();
    }
    
    // Obtener un producto por ID (manejando Optional correctamente)
    public Producto getProductoById(int id) {
        Optional<Producto> productoOpt = prodRepository.findById(id);
        if (productoOpt.isPresent()) {
            return productoOpt.get();
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
    }

    // Guardar un nuevo producto o actualizar uno existente
    public Producto saveProducto(Producto prod) {
        return prodRepository.save(prod);
    }

    // Actualizar un producto (en realidad ya se hace con el método save)
    public Producto updateProducto(Producto prod) {
        return prodRepository.save(prod);
    }

    // Eliminar un producto por ID
    public String deleteProducto(int id) {
        // Verificar si el producto existe antes de eliminarlo
        if (prodRepository.existsById(id)) {
            prodRepository.deleteById(id);
            return "Producto eliminado.";
        } else {
            return "Producto no encontrado con ID: " + id;
        }
    }
}
