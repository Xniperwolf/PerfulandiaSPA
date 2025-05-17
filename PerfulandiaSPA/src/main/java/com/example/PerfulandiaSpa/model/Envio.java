package com.example.PerfulandiaSpa.model;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Envios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Envio {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "origen_id")
    private Sucursal origen;

    @ManyToOne(optional = false)
    @JoinColumn(name = "destino_id")
    private Sucursal destino;

    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnvioDetalle> detalles;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoEnvio estado;

    @Column(nullable = false)
    private LocalDateTime fechaEnvio;

    private LocalDateTime fechaRecepcion;
}