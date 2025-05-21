package com.example.PerfulandiaSpa.repository;

import com.example.PerfulandiaSpa.model.EnvioDetalle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class EnvioDetalleRepository  {
    private final List<EnvioDetalle> detalles = new ArrayList<>();

    public EnvioDetalle guardar(EnvioDetalle detalle) {
        eliminar(detalle.getId());
        detalles.add(detalle);
        return detalle;
    }

    public List<EnvioDetalle> listar() {
        return Collections.unmodifiableList(detalles);
    }

    public Optional<EnvioDetalle> buscarPorId(Long id) {
        return detalles.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();
    }

    public void eliminar(Long id) {
        detalles.removeIf(d -> d.getId().equals(id));
    }

    public EnvioDetalle actualizar(EnvioDetalle detalle) {
        eliminar(detalle.getId());
        detalles.add(detalle);
        return detalle;
    }
}