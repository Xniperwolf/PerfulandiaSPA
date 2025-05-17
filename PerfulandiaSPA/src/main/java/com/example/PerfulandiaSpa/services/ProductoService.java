package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.Producto;
import com.example.PerfulandiaSpa.repository.ProductoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepositoryJpa productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(int id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }
}