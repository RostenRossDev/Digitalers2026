package Digitalers.clase3;

import java.io.InputStream;
import java.util.Scanner;

public class clase3 {

    static void main() {

        InputStream in = System.in;
        Scanner sc = new Scanner(in);
        System.out.println("Ingrese su edad: ");
        Integer edad = sc.nextInt();

//        if (edad >= 21) {
//            System.out.println("Usted ya es mayor de edad");
//        }
//
//        System.out.println("Fin del programa");

//        if (edad >= 21) {
//            System.out.println("Usted ya es MAYOR de edad");
//        } else {
//            System.out.println("Usted ya es MENOR de edad");
//        }
//        System.out.println("Fin del programa");


//        if(edad == 1){
//            System.out.println("Color Rojo");
//        } else if (edad == 2) {
//            System.out.println("Color Verde");
//        } else if (edad == 4) {
//            System.out.println("Color Amarillo");
//        } else {
//            System.out.println("Color Salmon");
//        }
//
//
//        if(edad == 1){
//            System.out.println("Color Rojo");
//        }
//
//        if (edad == 2) {
//            System.out.println("Color Verde");
//        }
//
//        if (edad == 4) {
//            System.out.println("Color Amarillo");
//        } else {
//            System.out.println("Color Salmon");
//        }
//
//
//        //IF anidados
//        if (edad == 4) {
//            if(edad != 4){
//                System.out.println("Color Salmon");
//            }
//            System.out.println("Color Amarillo");
//        }


        //######### Switch

        switch (edad){
            case 1:
                System.out.println("Se creo el Usuario.");
                break;
            case 3:
                System.out.println("Colectivo");
                break;
            default:
                System.out.println("Caso por defecto");
        }

        //funciones lambda o funciones anonimas
        switch (edad) {
            case 1 -> System.out.println("Se creo el Usuario.");
            case 3 -> System.out.println("Colectivo");
            default -> System.out.println("Caso por defecto");
        }

        switch (edad) {
            case 1, 2, 3 -> System.out.println("Niño");
            case 21, 22, 55 -> System.out.println("Adulto");
            default -> System.out.println("Otro");
        }


        String mensaje = switch (edad) {
            case 1 -> "Bebé";
            case 18 -> "Adulto";
            default -> "Desconocido";
        };

        System.out.println("Mensaje: " + mensaje);


        String opcion = "guardar";

        switch (opcion) {
            case "guardar" -> System.out.println("Guardando");
            case "eliminar" -> System.out.println("Eliminando");
            default -> System.out.println("Opción inválida");
        }

        Integer numeroInt = 12;
        Object obj = numeroInt;

        switch (obj) {
            case String s -> System.out.println("Texto: " + s);
            case Integer i -> System.out.println("Número: " + i);
            case null -> System.out.println("Es null");
            default -> System.out.println("Otro tipo");
        }

        Object obj2 = "100";

        switch (obj2) {
            case Integer i when i > 100 ->
                    System.out.println("Mayor a 100");

            case Integer i ->
                    System.out.println("Entero común");

            default ->
                    System.out.println("Otro tipo");
        }
    }
}
