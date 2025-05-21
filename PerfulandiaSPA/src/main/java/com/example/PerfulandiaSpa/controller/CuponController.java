package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.Cupon;
import com.example.PerfulandiaSpa.services.CuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cupones")
public class CuponController {

    @Autowired
    private CuponService cuponService;

    @PostMapping
    public ResponseEntity<Cupon> createCupon(@RequestBody Cupon cupon) {
        return ResponseEntity.ok(cuponService.saveCupon(cupon));
    }

    @GetMapping
    public ResponseEntity<List<Cupon>> getAllCupones() {
        return ResponseEntity.ok(cuponService.getAllCupones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cupon> getCuponById(@PathVariable Long id) {
        return cuponService.getCuponById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCupon(@PathVariable Long id) {
        cuponService.deleteCupon(id);
        return ResponseEntity.noContent().build();
    }
}