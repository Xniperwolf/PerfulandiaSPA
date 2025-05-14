package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.PerfulandiaSpa.model.Pedido;

@Repository
public class PedidoRepository {
    private List<Pedido> pedidos= new ArrayList<>();

    public Pedido Guardar(Pedido ped){
        pedidos.add(ped);
        return ped;
    }
    public List<Pedido> verPedidos(){
        return pedidos;
    } 
    public Pedido buscarPorId(int id){
        for (Pedido pedido : pedidos) {
            if (pedido.getId()==id) {
                return pedido;
            }
        }
        return null;
    }

    public Pedido actualizarPedido(Pedido ped){
        int id=0;
        int posicion=0;
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId()==ped.getId()) {
                id=ped.getId();
                posicion=1;
            }
        }
        Pedido pedi=new Pedido();
        pedi.setId(id);
        pedi.setEstado(ped.getEstado());
        pedi.setFechaCreacion(ped.getFechaCreacion());
        pedi.setProductos(ped.getProductos());
        pedidos.set(posicion, pedi);
        return pedi;

    }



}
