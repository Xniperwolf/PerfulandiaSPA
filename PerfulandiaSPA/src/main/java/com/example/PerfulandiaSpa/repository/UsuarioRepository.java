package com.example.PerfulandiaSpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PerfulandiaSpa.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar usuario por nombre de usuario
    Optional<Usuario> findByUsername(String username);

    // Buscar usuario por correo electrónico
    Optional<Usuario> findByEmail(String email);
}