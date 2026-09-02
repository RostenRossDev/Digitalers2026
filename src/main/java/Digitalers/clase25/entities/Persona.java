package Digitalers.clase25.entities;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private Long personaId;
    private String nombre;
    private String apellido;
    private String documento;
    private String direccion;
    private String telefono;
    private String correo;
}
