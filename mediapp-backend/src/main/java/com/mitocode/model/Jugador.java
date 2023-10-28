package com.mitocode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jugador")
public class Jugador{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNombre;
    private Integer nombre;
    private Integer posicion;

    @OneToOne
    @JoinColumn(name = "idCamisa")
    private Camisa camisa;
}