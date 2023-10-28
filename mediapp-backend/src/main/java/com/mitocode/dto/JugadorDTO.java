        package com.mitocode.dto;

        import com.mitocode.model.Jugador;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JugadorDTO {

    private Integer idNombre;
    private Integer nombre;
    private Integer posicion;
}
