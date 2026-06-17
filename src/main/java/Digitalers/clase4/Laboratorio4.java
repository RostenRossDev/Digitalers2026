package Digitalers.clase4;

import java.util.Scanner;

public class Laboratorio4 {
    static void main() {
        ejercicio1();
    }

    public static void ejercicio1(){
        System.out.println("############## Ejercicio 1");
        int aparicionesLegnth = 37;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una frase/palabra por teclado: ");
        String frase = sc.nextLine();
        String[] apariciones = new String[aparicionesLegnth]; // {i, z, e, x. ...}
        Integer[] repeticiones = new Integer[aparicionesLegnth]; // {1, 4, 2, 1 ...}
        Integer[] repeticionesMaximasIndices = new Integer[apariciones.length];

        int longitud = frase.length();

        String letra = String.valueOf(frase.charAt(0)); //Obtengo el caracter en el indice que valga 'i' en forma de String

        apariciones[0] = letra;
        repeticiones[0] = 1;

        int ultimoIngreso = 0;

        //Recorremos letras y contamos repeticiones
        for (int i = 1; i < longitud; i++ ){  //Recorre toda la frase ingresada por teclado
            letra = String.valueOf(frase.charAt(i)); //Obtengo el caracter en el indice que valga 'i' en forma de String

            if(letra.equals(" ")){
                continue;
            }

            boolean agregamos = true;

            for (int a = 0; a <= ultimoIngreso; a++) {  // recorrer el arreglo de apariciones para evaluar si se repite la letra

                String aparicion = apariciones[a];  //representa la letra del arreglo apariciones que se esta evaluando

                if(aparicion.equals(letra)){
                    repeticiones[a] = repeticiones[a] + 1; // incrementamos el valor de la repeticion en uno.
                    agregamos = false;
                }
            }

            if(agregamos){
                ultimoIngreso++;
                apariciones[ultimoIngreso] = letra;
                repeticiones[ultimoIngreso] = 1;
            }
        }


        //hasta aca esta joya

        //Encontrar el numero de aparicion maxima
        int mayorAparicion = 1;
        for (int i = 0; i < ultimoIngreso; i++){
            int valorRepeticion = repeticiones[i];
            if (valorRepeticion > mayorAparicion){
                mayorAparicion = valorRepeticion;
            }
        }

        //Hora encontramos las letras que tienen el numero de aparicion maxima         repeticionesMaximasIndices
        int repeticionesMaximasSiguiente = 0;
        for (int i = 0; i < ultimoIngreso; i++){
            int valorRepeticion = repeticiones[i];
            if (valorRepeticion == mayorAparicion){
                repeticionesMaximasIndices[repeticionesMaximasSiguiente] = i;
                repeticionesMaximasSiguiente++;
            }
        }

        System.out.println("Maximo de repeticiones: " + mayorAparicion);
        System.out.println("Las letras que mas se repiten son: ");
        for (int i = 0; i < repeticionesMaximasSiguiente; i++) {
            int letraIndex = repeticionesMaximasIndices[i];
            System.out.println(apariciones[letraIndex]);
        }

    }
}
