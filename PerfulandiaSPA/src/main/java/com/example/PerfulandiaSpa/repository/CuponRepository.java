package com.example.PerfulandiaSpa.repository;

import com.example.PerfulandiaSpa.model.Cupon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class CuponRepository {
    private final List<Cupon> cupones = new ArrayList<>();

    public Cupon save(Cupon cupon) {
        Cupon cup = new Cupon();
        cup.setId(cupon.getId());
        cup.setCodigo_cupon(cupon.getCodigo_cupon());
        cup.setDescuento(cupon.getDescuento());
        cup.setActivo(cupon.isActivo());

        cupones.add(cup);
        return cup;
    }

    public List<Cupon> findAll() {
        return Collections.unmodifiableList(cupones);
    }

    public Optional<Cupon> findById(Long id) {
        return cupones.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {
        cupones.removeIf(c -> c.getId().equals(id));
    }

    public Cupon update(Cupon cupon) {
        deleteById(cupon.getId());
        cupones.add(cupon);
        return cupon;
    }
}