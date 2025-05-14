package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PerfulandiaSpa.model.Pedido;




public interface PedidoRepositoryJPA extends JpaRepository<Pedido, Integer>{
    Pedido findById(int id);

}
