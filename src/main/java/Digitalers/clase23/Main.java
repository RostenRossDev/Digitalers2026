package Digitalers.clase23;

import Digitalers.clase21.test1.Auto;
import Digitalers.clase21.test1.Vehiculo;
import Digitalers.clase23.miColeccion.Lista;
import Digitalers.clase23.miColeccion.Nodo;

import java.util.*;

public class Main {

    static void main() {
/*
        Long.MAX_VALUE  ->> BIGINT
        Integer.MAX_VALUE  ->> INT
        Short.MAX_VALUE  ->> SMALLINT
        Byte.MAX_VALUE --> SOLO LAMITAD DE UN TINYINT
*/

        List<String> alumnoos = new ArrayList<>();

        Lista<String> alumnos = new Lista<>("Nestor");
        alumnos.agregar("Matias");
        alumnos.agregar("Marcos");
        alumnos.agregar("Lucas");
        alumnos.agregar("Josue");
        alumnos.agregar("Pepe");
        alumnos.agregar("Dardo");
        System.out.println(alumnos.getCantidad());

        alumnos.agregarDespuesDe("Nuevo Alumno", 2);

        Nodo<String> nodo  = alumnos.getPrimero();
        Boolean esUltimo = false;

        while (!esUltimo){
            if (nodo.getNext() == null){
                esUltimo = true;
            }
            System.out.println(nodo.getValor());
            nodo = nodo.getNext();

        }
    }




}
