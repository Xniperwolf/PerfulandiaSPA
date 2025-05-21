package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.Envio;


public interface EnvioRepositoryJpa extends JpaRepository<Envio, Integer> {
    
}