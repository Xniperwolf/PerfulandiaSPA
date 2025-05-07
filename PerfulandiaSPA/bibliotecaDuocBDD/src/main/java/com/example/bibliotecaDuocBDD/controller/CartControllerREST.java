package com.example.bibliotecaDuocBDD.controller;

import com.example.bibliotecaDuocBDD.model.Perfume;
import com.example.bibliotecaDuocBDD.services.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfumes")
public class CartControllerREST {

    @Autowired
    private PerfumeService perfumeService;

    @GetMapping
    public List<Perfume> getPerfumes() {
        return perfumeService.getPerfumes();
    }

    @GetMapping("/{id}")
    public Perfume getPerfumeById(@PathVariable int id) {
        return perfumeService.getPerfumeById(id);
    }

    @PostMapping
    public Perfume createPerfume(@RequestBody Perfume perfume) {
        return perfumeService.savePerfume(perfume);
    }

    @PutMapping("/{id}")
    public Perfume updatePerfume(@PathVariable int id, @RequestBody Perfume perfume) {
        perfume.setId(id);  // Asegúrate de que el ID coincida
        return perfumeService.updatePerfume(perfume);
    }

    @DeleteMapping("/{id}")
    public String deletePerfume(@PathVariable int id) {
        perfumeService.deletePerfume(id);
        return "Perfume eliminado";
    }
}