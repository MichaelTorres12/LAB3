package com.mitocode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "camisa")
public class Camisa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCamisa;
    private Integer numeroCamisa;

    @OneToOne(mappedBy = "camisa")
    private Jugador jugador;
}