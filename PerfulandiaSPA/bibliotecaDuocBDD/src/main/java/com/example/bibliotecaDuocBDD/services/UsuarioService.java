package com.example.bibliotecaDuocBDD.services;

import com.example.bibliotecaDuocBDD.model.Usuario;
import com.example.bibliotecaDuocBDD.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    // Guardar un nuevo usuario
    public Usuario saveUser(Usuario user) {
        return userRepository.save(user);
    }

    // Obtener todos los usuarios
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuario> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Buscar un usuario por nombre de usuario
    public Optional<Usuario> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Buscar un usuario por correo electrónico
    public Optional<Usuario> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Eliminar un usuario
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}