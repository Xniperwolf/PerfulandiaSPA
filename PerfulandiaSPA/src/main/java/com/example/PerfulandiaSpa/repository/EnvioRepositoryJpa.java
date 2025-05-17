package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.Envio;
import java.util.Optional;

public interface EnvioRepositoryJpa extends JpaRepository<Envio, Integer> {
    Optional<Envio> findById(Integer id);
}