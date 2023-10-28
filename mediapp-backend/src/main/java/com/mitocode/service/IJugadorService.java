package com.mitocode.service;

import com.mitocode.model.Jugador;

import java.util.Arrays;
import java.util.List;

public interface IJugadorService {
    Jugador findById(Integer id);

    Jugador save(Jugador jugador);

    Jugador update(Jugador jugador);

    void delete(Integer id);

    List<Jugador> findAll();  // Cambia Arrays a List<Jugador>
}
