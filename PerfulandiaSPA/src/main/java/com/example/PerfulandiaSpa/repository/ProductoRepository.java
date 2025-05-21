package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.example.PerfulandiaSpa.model.Producto;
import com.example.PerfulandiaSpa.model.Provedor;

@Repository
public class ProductoRepository {
    private final List<Producto> listaProductos = new ArrayList<>();

    public List<Producto> listarProductos() {
        return Collections.unmodifiableList(listaProductos);
    }

    public Optional<Producto> buscarPorId(int id) {
        return listaProductos.stream()
                .filter(producto -> producto.getId_producto() == id)
                .findFirst();
    }

    public Producto guardar(Producto prod) {
        eliminar(prod.getId_producto());
        listaProductos.add(prod);
        return prod;
    }

    public Producto actualizar(Producto prod) {
        eliminar(prod.getId_producto());
        listaProductos.add(prod);
        return prod;
    }

    public void eliminar(int id) {
        listaProductos.removeIf(producto -> producto.getId_producto() == id);
    }

    public List<Producto> findByProveedor(Provedor proveedor) {
        List<Producto> productosPorProveedor = new ArrayList<>();
        for (Producto producto : listaProductos) {
            if (producto.getProveedor() != null && producto.getProveedor().equals(proveedor)) {
                productosPorProveedor.add(producto);
            }
        }
        return productosPorProveedor;
    }
    
}