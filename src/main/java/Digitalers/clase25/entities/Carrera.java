package Digitalers.clase25.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Carrera {
    private Long carreraId;
    private String nombre;
    private Facultad facultad;
}
