package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.PerfulandiaSpa.model.Pedido;

@Repository
public class PedidoRepository {
    private List<Pedido> pedidos = new ArrayList<>();

    // Método para guardar un nuevo pedido
    public Pedido guardar(Pedido ped) {
        pedidos.add(ped);
        return ped;
    }

    // Método para ver todos los pedidos
    public List<Pedido> verPedidos() {
        return pedidos;
    }

    // Método para buscar un pedido por su ID
    public Pedido buscarPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    // Método para actualizar un pedido existente
    public Pedido actualizarPedido(Pedido ped) {
        int posicion = -1;
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId() == ped.getId()) {
                posicion = i; // Guardamos la posición correcta
                break;
            }
        }

        // Si no se encontró el pedido, retornar null o lanzar una excepción
        if (posicion == -1) {
            return null; // Pedido no encontrado
        }

        // Actualizamos el pedido
        Pedido pedidoExistente = pedidos.get(posicion);
        pedidoExistente.setEstado(ped.getEstado());
        pedidoExistente.setFechaCreacion(ped.getFechaCreacion());
        pedidoExistente.setProductos(ped.getProductos());

        return pedidoExistente;
    }
}
