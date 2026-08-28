package Digitalers.clase25.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    private Long cursoId;
    private String fecha;
    private Docente docente;
    private Materia materia;
    private List<Alumno> alumnos;
    private Carrera carrera;
    private Aula aula;
}
