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

    public Envio saveEnvio(Envio envio) {
        // Si el envío ya existe, actualízalo
        this.deleteById(envio.getId());
        listaEnvios.add(envio);
        return envio;
    }

    public List<Envio> listEnvios() {
        return Collections.unmodifiableList(listaEnvios);
    }

    public Optional<Envio> searchById(long id) {
        return listaEnvios.stream()
                .filter(envio -> envio.getId() == id)
                .findFirst();
    }

    public boolean deleteById(long id) {
        return listaEnvios.removeIf(envio -> envio.getId() == id);
    }

    public Envio updateEnvio(Envio envioActualizado) {
        Optional<Envio> existente = searchById(envioActualizado.getId());
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