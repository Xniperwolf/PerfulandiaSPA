package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.Provedor;
import com.example.PerfulandiaSpa.repository.ProvedorRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class ProvedorService {

    @Autowired
    private ProvedorRepositoryJpa provedorRepository;

    public List<Provedor> getAllProvedores() {
        return provedorRepository.findAll();
    }

    public Provedor getProvedorById(int id) {
        return provedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provedor no encontrado con ID: " + id));
    }

    public Provedor saveProvedor(Provedor provedor) {
        return provedorRepository.save(provedor);
    }

    public void deleteProvedor(int id) {
        provedorRepository.deleteById(id);
    }
}