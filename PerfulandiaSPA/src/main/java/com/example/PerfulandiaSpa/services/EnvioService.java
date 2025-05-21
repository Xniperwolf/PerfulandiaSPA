package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.Envio;
import com.example.PerfulandiaSpa.repository.EnvioRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class EnvioService {

    @Autowired
    private EnvioRepositoryJpa envioRepository;

    public List<Envio> getAllEnvios() {
        return envioRepository.findAll();
    }

    public Envio getEnvioById(int id) {
        return envioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Envio no encontrado con ID: " + id));
    }

    public Envio saveEnvio(Envio envio) {
        return envioRepository.save(envio);
    }

    public void deleteEnvio(int id) {
        envioRepository.deleteById(id);
    }
}
