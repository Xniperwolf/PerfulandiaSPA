package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.example.PerfulandiaSpa.model.Pedido;
import com.example.PerfulandiaSpa.model.Sucursal;
import com.example.PerfulandiaSpa.model.Usuario;

@Repository
public class PedidoRepository {
    private final List<Pedido> pedidos = new ArrayList<>();

    public Pedido guardar(Pedido ped) {
        eliminarPorId(ped.getId());
        pedidos.add(ped);
        return ped;
    }

    public List<Pedido> verPedidos() {
        return Collections.unmodifiableList(pedidos);
    }

    public Optional<Pedido> buscarPorId(int id) {
        return pedidos.stream().filter(p -> p.getId() == id).findFirst();
    }

    public boolean eliminarPorId(int id) {
        return pedidos.removeIf(p -> p.getId() == id);
    }

    public Pedido actualizarPedido(Pedido ped) {
        Optional<Pedido> existente = buscarPorId(ped.getId());
        if (existente.isPresent()) {
            int idx = pedidos.indexOf(existente.get());
            pedidos.set(idx, ped);
            return ped;
        }
        pedidos.add(ped);
        return ped;
    }

    public List<Pedido> findByUsuario(Usuario usuario) {
        List<Pedido> result = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getUsuario() != null && p.getUsuario().equals(usuario)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Pedido> findBySucursal(Sucursal sucursal) {
        List<Pedido> result = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getSucursal() != null && p.getSucursal().equals(sucursal)) {
                result.add(p);
            }
        }
        return result;
    }

}