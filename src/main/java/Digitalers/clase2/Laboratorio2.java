package Digitalers.clase2;

import java.io.InputStream;
import java.util.Scanner;

public class Laboratorio2 {
    static void main() {
        ejercicio1();
        ejercicio2();
    }

    public static void ejercicio1() {
        System.out.println("############### Ejercicio 1");

        final Short MAX_VALUE = 255;

        Double aux = Math.random();
//        aux = Math.round(aux);

//        Short red = (Math.random() * MAX_VALUE) + 1 ; double 245.0
//
//        Short red =(Double) ((Math.random() * MAX_VALUE) + 1) ;
//
//        Short red =((Double) ( (Math.random() * MAX_VALUE) + 1 )).shortValue();

        Short red =( (Double) ( (Math.random() * MAX_VALUE) + 1 )).shortValue();
        Short green =( (Double) ( (Math.random() * MAX_VALUE) + 1 )).shortValue();
        Short blue =( (Double) ( (Math.random() * MAX_VALUE) + 1 )).shortValue();

        System.out.println("R: " + red);
        System.out.println("G: " + green);
        System.out.println("B: " + blue);

        System.out.println(String.format("RGB(%d, %d, %d)", red, green, blue));

    }

    public static void ejercicio2() {
        System.out.println("############### Ejercicio 2");
        InputStream stream = System.in;

        Scanner sc = new Scanner(stream);

        final Short MAX_VALUE = 122;
        final Short MIN_VALUE = 97;
        final Short DELTA = 122 - 97;
        Double random = Math.random();

        //Short number =( (Double) ( (Math.random() * MAX_VALUE) + MIN_VALUE )).shortValue();
        Short number = (short) (Math.random() * (DELTA + 1) + MIN_VALUE);


        System.out.println(String.format("Numeros => %d", number));
        int charNumber = number.intValue();
        char caracter = (char) charNumber;

//        Character character = new Character(caracter);

        System.out.println(String.format("%d = %s", number, caracter));
    }
}
