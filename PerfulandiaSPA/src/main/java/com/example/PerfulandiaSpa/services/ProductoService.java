package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.Producto;
import com.example.PerfulandiaSpa.model.Provedor;
import com.example.PerfulandiaSpa.repository.ProductoRepository;
import com.example.PerfulandiaSpa.repository.ProductoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepositoryJpa productoRepositoryJpa;
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepositoryJpa.findAll();
    }

    public Producto getProductoById(int id) {
        return productoRepositoryJpa.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    public Producto saveProducto(Producto producto) {
        return productoRepositoryJpa.save(producto);
    }

    public void deleteProducto(int id) {
        productoRepositoryJpa.deleteById(id);
    }

        public List<Producto> getProductosByProveedor(Provedor proveedor) {
        return productoRepository.findByProveedor(proveedor);
    }
}