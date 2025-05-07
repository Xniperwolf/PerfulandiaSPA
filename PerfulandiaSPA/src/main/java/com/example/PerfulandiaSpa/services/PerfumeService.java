package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.Perfume;
import com.example.PerfulandiaSpa.repository.PerfumeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfumeService {

    @Autowired
    private PerfumeRepositoryJPA perfumeRepository;

    // Obtener todos los perfumes
    public List<Perfume> getPerfumes() {
        return perfumeRepository.findAll();
    }

    // Obtener un perfume por su ID
    public Perfume getPerfumeById(int id) {
        return perfumeRepository.findById(id);
    }

    // Crear un nuevo perfume
    public Perfume savePerfume(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    // Actualizar un perfume existente
    public Perfume updatePerfume(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    // Eliminar un perfume por ID
    public void deletePerfume(int id) {
        perfumeRepository.deleteById(id);
    }
}