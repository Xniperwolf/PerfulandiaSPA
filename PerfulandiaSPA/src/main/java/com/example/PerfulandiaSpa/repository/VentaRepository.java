package com.example.PerfulandiaSpa.repository;

import com.example.PerfulandiaSpa.model.Usuario;
import com.example.PerfulandiaSpa.model.Venta;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class VentaRepository {
    private final List<Venta> ventas = new ArrayList<>();

    public Venta guardar(Venta venta) {
        eliminar(venta.getId());
        ventas.add(venta);
        return venta;
    }

    public List<Venta> listar() {
        return Collections.unmodifiableList(ventas);
    }

    public Optional<Venta> buscarPorId(Long id) {
        return ventas.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    public void eliminar(Long id) {
        ventas.removeIf(v -> v.getId().equals(id));
    }

    public Venta actualizar(Venta venta) {
        eliminar(venta.getId());
        ventas.add(venta);
        return venta;
    }

     public List<Venta> findByUsuario(Usuario usuario){
        List<Venta> ventasUsuario = new ArrayList<>();
        for (Venta venta : ventas) {
            if (venta.getUsuario() != null && venta.getUsuario().getId().equals(usuario.getId())) {
                ventasUsuario.add(venta);
            }
        }
        return ventasUsuario;
     }
}