package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.PerfulandiaSpa.model.Producto;

@Repository
public class ProductoRepository {
    private List<Producto> ListaProductos=new ArrayList<>();

    public List<Producto> listarProductos(){
        return ListaProductos;
    }
    public Producto buscarPorId(int id){
        for (Producto producto : ListaProductos) {
            if (producto.getId_producto()==id) {
                return producto;
            }
        }
        return null;
    } 
    
    public Producto guardar(Producto prod){
        ListaProductos.add(prod);
        return prod;
    }

    public Producto actualizar(Producto prod){
        int id=0;
        int posicion=0;
        for (int i = 0; i < ListaProductos.size(); i++) {
            if (ListaProductos.get(i).getId_producto()==prod.getId_producto()) {
                id=prod.getId_producto();
                posicion=1;
            }
        }
        Producto prod1=new Producto();
        prod1.setId_producto(id);
        prod1.setNombre(prod.getNombre());
        prod1.setCategoria(prod.getCategoria());
        prod1.setEstado(prod.getEstado());
        prod1.setPrecio(prod.getPrecio());
        prod1.setStock_total(prod.getStock_total());
        ListaProductos.set(posicion,prod1);
        return prod1;
    }

    public void eliminar(int id){
        Producto prod =buscarPorId(id);
        if (prod!=null) {
            ListaProductos.remove(prod);
        }
    }

}
