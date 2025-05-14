package com.example.PerfulandiaSpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Envios;

public interface EnvioRepositoryJpa extends JpaRepository<Envios,Long>{
    public Envios findById(int id);
}
