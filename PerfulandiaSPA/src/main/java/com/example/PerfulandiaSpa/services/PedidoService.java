package com.example.PerfulandiaSpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PerfulandiaSpa.model.Pedido;
import com.example.PerfulandiaSpa.repository.PedidoRepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PedidoService {
    @Autowired
    private PedidoRepositoryJPA pedidoRepo;
    public List<Pedido> getPedidos(){
        return pedidoRepo.findAll();
    }
    public Pedido getPedidoById(int id){
        return pedidoRepo.findById(id).orElse(null);
    }
    public Pedido savePedido(Pedido ped){
        return pedidoRepo.save(ped);
    }
    public Pedido updatePedido(Pedido ped){
        return pedidoRepo.save(ped);
    }
}
