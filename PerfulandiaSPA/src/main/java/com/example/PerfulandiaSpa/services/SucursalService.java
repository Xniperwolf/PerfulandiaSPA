// filepath: [SucursalService.java](http://_vscodecontentref_/0)
package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.Sucursal;
import com.example.PerfulandiaSpa.repository.SucursalRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class SucursalService {

    @Autowired
    private SucursalRepositoryJpa sucursalRepository;

    public List<Sucursal> getAllSucursales() {
        return sucursalRepository.findAll();
    }

    public Sucursal getSucursalById(Long id) {
        return sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con ID: " + id));
    }

    public Sucursal saveSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public void deleteSucursal(Long id) {
        sucursalRepository.deleteById(id);
    }
}