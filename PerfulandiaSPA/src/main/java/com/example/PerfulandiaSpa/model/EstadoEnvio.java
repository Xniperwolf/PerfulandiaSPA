package com.example.PerfulandiaSpa.model;



import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="EstadoEnvio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoEnvio {
    private Long id;
    private String nombre;
    private String descripcion;

    @ManyToOne 
    private Envio envio;

}