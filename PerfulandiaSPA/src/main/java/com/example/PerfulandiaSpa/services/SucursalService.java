package com.example.PerfulandiaSpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.PerfulandiaSpa.model.Sucursal;
import com.example.PerfulandiaSpa.repository.SucursalRepositoryJpa;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SucursalService {
    
    @Autowired
    private SucursalRepositoryJpa sucursalRepsoitory;

    public List<Sucursal> getSucursal(){
        return sucursalRepsoitory.findAll();
    }
    public Sucursal updateSucursal(Sucursal suc){
        return sucursalRepsoitory.save(suc); 
    }
    public Sucursal getSucursalById(int id){
        return sucursalRepsoitory.findById(id);

    }
        public Sucursal saveSucursal(Sucursal suc){
        return sucursalRepsoitory.save(suc);
    }
}
