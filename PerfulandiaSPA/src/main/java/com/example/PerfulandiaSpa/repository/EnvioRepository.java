package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.PerfulandiaSpa.model.Envios;





@Repository
public class EnvioRepository {
    public List<Envios> listaEnvios= new ArrayList<>();

    public Envios guardarEnvios(Envios envio){
        listaEnvios.add(envio);
        return envio;
    }
    public List<Envios> verEnvios(){
        return listaEnvios;
    }
    public Envios BuscarPorID(int id){
        for (Envios envios : listaEnvios) {
            if (envios.getId()==id) {
                return envios;
            }
        }
        return null;
    }

    public Envios actualizarEnvios(Envios env){
        int id=0;
        int posicion=0;
        for (int i = 0; i < listaEnvios.size(); i++) {
            if (listaEnvios.get(i).getId()==env.getId()) {
                id=env.getId();
                posicion=1;
            }
        }
        Envios envi= new Envios();
        envi.setId(id);
        envi.setDestino(env.getDestino());
        envi.setEstado(env.getEstado());
        envi.setOrigen(envi.getOrigen());
        envi.setSucursal(envi.getSucursal());
        envi.setProductos(env.getProductos());
        listaEnvios.set(posicion, envi);
        return envi;

    }

}
