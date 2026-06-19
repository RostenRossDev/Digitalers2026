package Digitalers.clase5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class clase5 {
    static void main() {
        //################### Arreglos
//        String[] alumnos = new String[5]; //Inicializa todos sus valores en NULL
//        //indice del ultimo elemento de un arreglo es su largo menos 1 (alumnos.length - 1)
//        int[] primitivosEnteros = new int[20];  //Inicializa todos los valores en CERO 0
//        primitivosEnteros[0] = 2;
//        primitivosEnteros[1] = 7;
//        primitivosEnteros[2] = 34;
//        primitivosEnteros[3] = 55;
//
//        char[] primitivosDeCaracter = new char[20]; //Inicializa todos los valores con espacio vacio
//        Character[] Caracteres = new Character[20]; //Inicializa todos sus valores en NULL
//
//        alumnos[0] = "Juan";
//        alumnos[1] = "Maria";
//        alumnos[2] = "Pepe";
//        alumnos[3] = "Moni";
//        alumnos[4] = "Jose";
//        //alumnos.length; // me devuelve la longitud del arreglo.
//        alumnos.clone();// nos devuelve un clon del arreglo.
//
//        Arrays.stream(alumnos).collect(Collectors.toList());
//
//
//        //filter
//        String[] nombresConJ = Arrays.stream(alumnos) //convertimos el arreglo alumnos en un flujo de datos STREAM
//                .filter(nombre -> nombre.charAt(0) == 'J' || nombre.charAt(0) == 'j') //aplicamos el metodo filter con una condicion
//                .toArray(String[]::new);
//
//       int[] pares = Arrays.stream(primitivosEnteros)
//               .filter(item -> item % 2 != 0)
//               .toArray();
//
//
//
//        for (int i = 0; i < alumnos.length; i++) {
//            System.out.println(alumnos[i]);
//        }
//
//        int[] vector = {150,500,3,4,5,6};  //inicializar un arreglo con valores iniciales..
//        vector[0]++;
//        System.out.println(vector[0]);


        //### Funciones y procedimientos
        Scanner sc = new Scanner(System.in);
        calculadora(sc);
        sc.close();
//      ........
    }

    public static void calculadora(Scanner sc){
        mostrarOpciones();
        operar(sc);
        System.out.println("Fin del programa");
    }

    public static void mostrarOpciones(){
//        System.out.println("Presione" +
//                "\n1 para sumar." +
//                "\n2 para restar." +
//                "\n3 para multiplicar." +
//                "\n4 para dividir." +
//                "\n5 para salir. ");
        System.out.println("""
                Presione:
                1 para sumar.
                2 para restar.
                3 para multiplicar.
                4 para dividir.
                5 para salir.
                """);
    }

    public static Integer capturarOpcion(Scanner sc){
        //Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor: ");
        Integer num = sc.nextInt();
        return num;
    }

    public static Double capturarOperandos(Scanner sc){
//        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor: ");
        Double num = sc.nextDouble();
        return num;
    }

    public static void operar(Scanner sc){
        int op = capturarOpcion(sc);
        System.out.println("Hola");
        Double num1;// = capturarOperandos();
        Double num2;// = capturarOperandos();
        Double resultado;

        switch (op) {
            case 1:
                num1 = capturarOperandos(sc);
                num2 = capturarOperandos(sc);
//              resultado = sumar(capturarOperandos(), capturarOperandos());
                resultado = sumar(num1, num2);
//              System.out.println( "La suma es: " + sumar(num1, num2));
                System.out.println( "La suma es: " + resultado);
                break;
            case 2:
                num1 = capturarOperandos(sc);
                num2 = capturarOperandos(sc);
                resultado = restar(num1, num2);
                System.out.println( "La resta es: " + resultado);
                break;
            case 3:
                num1 = capturarOperandos(sc);
                num2 = capturarOperandos(sc);
                resultado = multiplicar(num1, num2);
                System.out.println( "La multiplicacion es: " + resultado);
                break;
            case 4:
                num1 = capturarOperandos(sc);
                num2 = capturarOperandos(sc);
                resultado = dividir(num1, num2);
                System.out.println( "La division es: " + resultado);
                break;
            case 5:
                System.out.println("Cerrando calculadora ....");
            default:
                System.out.println("El numero ingresado no es una opcion valida.");
        }
    }

    public static Double sumar(double valor1, double valor2){
        return valor1 + valor2;
    }

    public static Double restar(double valor1, double valor2){
        return valor1 - valor2;
    }

    public static Double multiplicar(double valor1, double valor2){
        return valor1 * valor2;
    }

    public static Double dividir(double valor1, double valor2){
        if(valor2 != 0){
            return valor1 / valor2;
        } else {
           return null;
        }
    }
}
