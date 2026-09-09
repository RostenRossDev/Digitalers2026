package Digitalers.clase25.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno extends Persona {
    private Long alumnoId;
    private Long legajo;
    private List<Curso> cursos;
    public Alumno(String nombre, String apellido, String dni, String direccion, String telefono, String correo){
        setNombre(nombre);
        setApellido(apellido);
        setDocumento(dni);
        setDireccion(direccion);
        setTelefono(telefono);
        setCorreo(correo);
        setLegajo(Long.parseLong(generarNumeroAleatorio()));
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "legajo=" + legajo +
                ", alumnoId=" + alumnoId +
                super.toString() +
                '}';
    }

    private String generarNumeroAleatorio() {
        return ((int) (Math.random() * 9000) + 1000) + "";
    }
}
