package com.example.PerfulandiaSpa.repository;

import com.example.PerfulandiaSpa.model.Envio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class EnvioRepository {
    private final List<Envio> listaEnvios = new ArrayList<>();

    public Envio guardarEnvio(Envio envio) {
        // Si el envío ya existe, actualízalo
        this.eliminarPorId(envio.getId());
        listaEnvios.add(envio);
        return envio;
    }

    public List<Envio> verEnvios() {
        return Collections.unmodifiableList(listaEnvios);
    }

    public Optional<Envio> buscarPorId(long id) {
        return listaEnvios.stream()
                .filter(envio -> envio.getId() == id)
                .findFirst();
    }

    public boolean eliminarPorId(long id) {
        return listaEnvios.removeIf(envio -> envio.getId() == id);
    }

    public Envio actualizarEnvio(Envio envioActualizado) {
        Optional<Envio> existente = buscarPorId(envioActualizado.getId());
        if (existente.isPresent()) {
            int idx = listaEnvios.indexOf(existente.get());
            listaEnvios.set(idx, envioActualizado);
            return envioActualizado;
        }
        // Si no existe, lo agrega
        listaEnvios.add(envioActualizado);
        return envioActualizado;
    }
}