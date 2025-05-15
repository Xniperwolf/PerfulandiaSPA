package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PerfulandiaSpa.model.Envios;






public interface EnvioRepositoryJpa extends JpaRepository<Envios,Long>{
    public Envios findById(int id);
}
