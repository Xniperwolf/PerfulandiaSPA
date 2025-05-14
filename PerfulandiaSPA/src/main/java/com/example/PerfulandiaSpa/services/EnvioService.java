package com.example.PerfulandiaSpa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Envios;
import com.example.demo.Repository.EnvioRepositoryJpa;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EnvioService {
    @Autowired
    private EnvioRepositoryJpa envioRepository;
    public List<Envios>getEnvios() {
        return envioRepository.findAll();
    }
    public Envios getPedidoByID(int id){
        return envioRepository.findById(id);
    }
    public Envios saveEnvios(Envios envio){
        return envioRepository.save(envio);
    }
    public Envios updatEnvios(Envios envi){
        return envioRepository.save(envi);
    }

}
