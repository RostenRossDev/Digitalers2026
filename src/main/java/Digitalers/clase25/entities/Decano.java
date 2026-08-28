package Digitalers.clase25.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Decano extends Empleado {
    private Long decanoId;
    private LocalDateTime fechaInicio;
}
