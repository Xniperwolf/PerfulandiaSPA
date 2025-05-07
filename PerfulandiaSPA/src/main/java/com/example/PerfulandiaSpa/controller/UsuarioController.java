package com.example.PerfulandiaSpa.controller;

import com.example.PerfulandiaSpa.model.Usuario;
import com.example.PerfulandiaSpa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    // Crear un nuevo usuario
    @PostMapping
    public Usuario createUser(@RequestBody Usuario user) {
        return userService.saveUser(user);
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsers() {
        return userService.getAllUsers();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public Optional<Usuario> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Obtener un usuario por nombre de usuario (username)
    @GetMapping("/username/{username}")
    public Optional<Usuario> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    // Obtener un usuario por correo electrónico (email)
    @GetMapping("/email/{email}")
    public Optional<Usuario> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "Usuario eliminado";
    }
}
