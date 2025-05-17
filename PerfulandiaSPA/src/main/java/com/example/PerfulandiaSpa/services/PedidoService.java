package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.Pedido;
import com.example.PerfulandiaSpa.repository.PedidoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class PedidoService {

    @Autowired
    private PedidoRepositoryJpa pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(int id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    }

    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deletePedido(int id) {
        pedidoRepository.deleteById(id);
    }
}
