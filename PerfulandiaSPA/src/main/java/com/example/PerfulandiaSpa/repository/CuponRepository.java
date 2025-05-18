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
        deleteById(cupon.getId());
        cupones.add(cupon);
        return cupon;
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