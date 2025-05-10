package com.example.perfulandia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.perfulandia.Model.Pedido;




public interface PedidoRepositoryJPA extends JpaRepository<Pedido, Long>{
    Pedido findById(int id);

}
