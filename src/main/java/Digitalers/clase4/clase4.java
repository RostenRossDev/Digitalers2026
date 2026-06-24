package Digitalers.clase4;

import Digitalers.clase5.Integrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class clase4 {
    static void main() {

        Scanner sc = new Scanner(System.in);
//        System.out.println("Ingrese la tabla de multiplicar que desea ver: ");
//        int tabla = sc.nextInt();
//        int contador = 0;
//
//        //#### BUCLE WHILE O MIENTRAS
//        while (contador < 11) {
//            System.out.println(String.format("%d x %d = %d", tabla, contador, (tabla*contador)));
//            contador++; // ===>  contador = contador + 1;  contador += 1;
//        }
//        System.out.println("Fin del programa");


        //#### DO BUCLE WHILE O MIENTRAS
//        final int INTENTOS_MAXIMOS = 3;
//        int intentos = 0;
//        String clave = "1234";
//        System.out.println("Para iniciar sesión ingrese su clave: ");
//        do {
//            String clavePorTeclado = sc.nextLine();
//            if(clave.equals(clavePorTeclado)){
//                System.out.println("Has iniciado sesion.");
//                break;
//            }
//            System.out.println("Clave erronea.\nIntente nuvamente: ");
//            intentos++;
//        } while (intentos< INTENTOS_MAXIMOS);

        // Bucle FOR (para)
//        for (int i = 0; i < 50; i++) {
//            System.out.println("Index: " + i);
//        }
        List<String> palabras = new ArrayList<>();
        List<Integer> numeros = new ArrayList<>();
        palabras.add("leche");   // 0
        palabras.add("huevo");   // 1
        palabras.add("carne");   // 2
        palabras.add("pan");     // 3
        palabras.add("harina");  // 4
        palabras.add("fideo");   // 5
        palabras.add("arroz");   // 6

        for (int i = 0; i < 7; i++) {
            System.out.println(palabras.get(i));
        }

        //for each
        palabras.forEach(item -> System.out.println(item));

        for(String palabra : palabras){
            System.out.println(palabra);
        }

    }
}