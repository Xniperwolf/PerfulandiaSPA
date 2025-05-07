package com.example.bibliotecaDuocBDD.controller;

import com.example.bibliotecaDuocBDD.model.Perfume;
import com.example.bibliotecaDuocBDD.services.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perfumes") // Ruta base para las operaciones de perfume
public class PerfumeController {

    @Autowired
    private PerfumeService perfumeService;

    // Obtener todos los perfumes
    @GetMapping
    public List<Perfume> getAllPerfumes() {
        return perfumeService.getPerfumes();
    }

    // Obtener un perfume por su ID
    @GetMapping("/{id}")
    public Perfume getPerfumeById(@PathVariable int id) {
        return perfumeService.getPerfumeById(id);
    }

    // Crear un nuevo perfume
    @PostMapping
    public Perfume createPerfume(@RequestBody Perfume perfume) {
        return perfumeService.savePerfume(perfume);
    }

    // Actualizar un perfume existente
    @PutMapping("/{id}")
    public Perfume updatePerfume(@PathVariable int id, @RequestBody Perfume perfume) {
        perfume.setId(id); // Asegúrate de que el ID coincida
        return perfumeService.updatePerfume(perfume);
    }

    // Eliminar un perfume por ID
    @DeleteMapping("/{id}")
    public String deletePerfume(@PathVariable int id) {
        perfumeService.deletePerfume(id);
        return "Perfume eliminado";
    }
}
