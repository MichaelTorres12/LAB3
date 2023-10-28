package com.mitocode.controller;

import com.mitocode.dto.JugadorDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Jugador;
import com.mitocode.service.IJugadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private IJugadorService service;

    @Autowired
    private ModelMapper mapper;

        @GetMapping("/get")
        public ResponseEntity<List<JugadorDTO>> findAll() {
            List<JugadorDTO> list = service.findAll().stream()
                    .map(jugador -> mapper.map(jugador, JugadorDTO.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorDTO> findById(@PathVariable("id") Integer id) {
        JugadorDTO dtoResponse;
        Jugador jugador = service.findById(id);
        if (jugador == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            dtoResponse = mapper.map(jugador, JugadorDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody JugadorDTO dto) {
        Jugador jugador = mapper.map(dto, Jugador.class);
        Jugador savedJugador = service.save(jugador);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<JugadorDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody JugadorDTO dto) {
        Jugador jugador = service.findById(id);
        if (jugador == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        jugador.setNombre(dto.getNombre());
        jugador.setPosicion(dto.getPosicion());
        Jugador updatedJugador = service.update(jugador);
        JugadorDTO updatedDto = mapper.map(updatedJugador, JugadorDTO.class);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        Jugador jugador = service.findById(id);
        if (jugador == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            service.delete(id);
        }
        return ResponseEntity.noContent().build();
    }
}
