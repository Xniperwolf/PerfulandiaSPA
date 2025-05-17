package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.example.PerfulandiaSpa.model.Provedor;

@Repository
public class ProvedorRepository {
    private final List<Provedor> listaProvedores = new ArrayList<>();

    public Optional<Provedor> buscarPorId(int id) {
        return listaProvedores.stream()
                .filter(prov -> prov.getId() == id)
                .findFirst();
    }

    public List<Provedor> listarProvedores() {
        return Collections.unmodifiableList(listaProvedores);
    }

    public Provedor guardar(Provedor prov) {
        eliminar(prov.getId());
        listaProvedores.add(prov);
        return prov;
    }

    public Provedor actualizar(Provedor prov) {
        eliminar(prov.getId());
        listaProvedores.add(prov);
        return prov;
    }

    public void eliminar(int id) {
        listaProvedores.removeIf(prov -> prov.getId() == id);
    }
}