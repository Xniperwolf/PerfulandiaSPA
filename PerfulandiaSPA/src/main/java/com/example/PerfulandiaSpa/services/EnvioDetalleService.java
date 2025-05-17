package com.example.PerfulandiaSpa.services;

import com.example.PerfulandiaSpa.model.EnvioDetalle;
import com.example.PerfulandiaSpa.repository.EnvioDetalleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioDetalleService {

    @Autowired
    private EnvioDetalleRepository envioDetalleRepository;

    public EnvioDetalle saveEnvioDetalle(EnvioDetalle detalle) {
        return envioDetalleRepository.guardar(detalle);
    }

    public List<EnvioDetalle> getAllEnvioDetalles() {
        return envioDetalleRepository.listar();
    }

    public void deleteEnvioDetalle(Long id) {
        envioDetalleRepository.buscarPorId(id);
    }
}