package com.example.perfulandia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.perfulandia.Model.Sucursal;

public interface SucursalRepositoryJpa extends JpaRepository<Sucursal,Long> {
 // Método para encontrar un perfume por su ID
    Sucursal findById(int id);
    
}
