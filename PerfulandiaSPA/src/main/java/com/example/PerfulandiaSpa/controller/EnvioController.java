package com.example.PerfulandiaSpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PerfulandiaSpa.model.Envios;
import com.example.PerfulandiaSpa.services.EnvioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/envios")
public class EnvioController {
    @Autowired
    private EnvioService envioService;

    @GetMapping()
    public ResponseEntity<List<Envios>> getEnvios() {
        List<Envios> listaEnvios= envioService.getEnvios();
        if (listaEnvios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaEnvios);
    }

    @PostMapping()
    public ResponseEntity<Envios> SaveEnvio(@RequestBody Envios envi) {
        Envios envios=envioService.updatEnvios(envi);
        return ResponseEntity.status(HttpStatus.CREATED).body(envios);
    }
    @GetMapping("{id}")
    public ResponseEntity<Envios> getByID(@PathVariable int id) {
        try {
            Envios envi=envioService.getPedidoByID(id);
            return ResponseEntity.ok(envi);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<Envios> updateEnvios(@PathVariable int id, @RequestBody Envios env) {
        try {
            Envios envi=envioService.getPedidoByID(id);
            envi.setEstado(env.getEstado());
            envi.setDestino(env.getDestino());
            envi.setOrigen(env.getOrigen());
            envi.setProductos(env.getProductos());
            envi.setSucursal(env.getSucursal());
            envioService.updatEnvios(envi);
            return ResponseEntity.ok(envi);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
}
