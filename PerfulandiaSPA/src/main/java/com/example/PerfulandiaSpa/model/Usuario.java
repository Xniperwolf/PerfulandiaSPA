package com.example.PerfulandiaSpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @Column(nullable = false)
    private Long id; // Puede ser Long o int dependiendo de tus necesidades

    @Column(nullable = false, unique = true)
    private String username; // Nombre de usuario único

    @Column(nullable = false)
    private String password; // Contraseña del usuario (idealmente debe ser cifrada)

    @Column(nullable = false, unique = true)
    private String email; // Correo electrónico único

    // Otros campos que necesites (por ejemplo, nombre completo, roles, etc.)
    @Column(nullable  = false)
        private String Rol;
}