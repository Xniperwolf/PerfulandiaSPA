package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.Perfume;
import java.util.Optional;

public interface PerfumeRepositoryJPA extends JpaRepository<Perfume, Integer> {

    // Spring Data JPA ya proporciona este método por defecto
    // Perfume findById(int id); <-- No es necesario, porque JpaRepository ya lo tiene
    
    // Aquí cambiamos el retorno de Perfume a Optional<Perfume>
    Optional<Perfume> findById(int id);

    // Método para eliminar un perfume por su ID
    void deleteById(int id);
}
