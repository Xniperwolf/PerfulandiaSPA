package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.example.PerfulandiaSpa.model.Sucursal;

@Repository
public class SucursalRepository {

    private final List<Sucursal> listaSucursal = new ArrayList<>();

    public Optional<Sucursal> buscarPorId(Long id) {
        return listaSucursal.stream()
                .filter(sucursal -> sucursal.getId().equals(id))
                .findFirst();
    }

    public List<Sucursal> listarSucursales() {
        return Collections.unmodifiableList(listaSucursal);
    }

    public Sucursal guardar(Sucursal sucursal) {
        eliminar(sucursal.getId());
        listaSucursal.add(sucursal);
        return sucursal;
    }

    public Sucursal actualizar(Sucursal sucursal) {
        eliminar(sucursal.getId());
        listaSucursal.add(sucursal);
        return sucursal;
    }

    public void eliminar(Long id) {
        listaSucursal.removeIf(sucursal -> sucursal.getId().equals(id));
    }
}