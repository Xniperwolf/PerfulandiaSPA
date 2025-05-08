package com.example.perfulandia.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.perfulandia.Model.Producto;
//import com.example.perfulandia.Repository.ProdictoRepository;
import com.example.perfulandia.Repository.ProdictoRepositoryJpa;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ProductoService {
    @Autowired
    private ProdictoRepositoryJpa prodRepository;

    public List<Producto> getProducto(){
        return prodRepository.findAll();
    }
    
    public Producto getProductoById(int id){
        return prodRepository.findById(id);
    }
    public Producto saveProducto(Producto prod){
        return prodRepository.save(prod);
    }
    public Producto updateProducto(Producto prod){
        return prodRepository.save(prod);
    }
    public String deleteProducto(int id){
        prodRepository.deleteById(id);
        return"Producto eliminado..";
    }
}
