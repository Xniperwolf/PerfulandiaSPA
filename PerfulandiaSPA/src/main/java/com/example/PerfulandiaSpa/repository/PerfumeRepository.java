package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.PerfulandiaSpa.model.Perfume;

@Repository
public class PerfumeRepository {

    private List<Perfume> listaPerfumes = new ArrayList<>();

    // Obtener todos los perfumes
    public List<Perfume> obtenerPerfumes() {
        return listaPerfumes;
    }

    // Buscar un perfume por su ID
    public Perfume buscarPorId(int id) {
        for (Perfume perfume : listaPerfumes) {
            if (perfume.getId() == id) {
                return perfume;
            }
        }
        return null;
    }

    // Guardar un nuevo perfume
    public Perfume guardar(Perfume perfume) {
        listaPerfumes.add(perfume);
        return perfume;
    }

    // Actualizar un perfume existente
    public Perfume actualizar(Perfume perfume) {
        int id = perfume.getId();
        int posicion = 0;
        // Buscar la posición del perfume en la lista
        for (int i = 0; i < listaPerfumes.size(); i++) {
            if (listaPerfumes.get(i).getId() == id) {
                posicion = i;
                break;
            }
        }

        // Verificar si el perfume existe y actualizar
        if (posicion != 0 || listaPerfumes.get(0).getId() == id) {
            Perfume perfumeExistente = listaPerfumes.get(posicion);
            perfumeExistente.setNombrePerfume(perfume.getNombrePerfume());
            perfumeExistente.setMarca(perfume.getMarca());
            perfumeExistente.setPrecio(perfume.getPrecio());
            perfumeExistente.setFechaPublicacion(perfume.getFechaPublicacion());
            return perfumeExistente;
        }
        return null;
    }

    // Eliminar un perfume por su ID
    public void eliminar(int id) {
        Perfume perfume = buscarPorId(id);
        if (perfume != null) {
            listaPerfumes.remove(perfume);
        }
    }
}