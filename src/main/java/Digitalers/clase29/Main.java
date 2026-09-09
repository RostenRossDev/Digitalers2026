package Digitalers.clase29;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {
//        int num1 = 12;
//        int num2 = 3;
//        int resultado;
//
//        CalculadoraFuncional calculadora;
//
//        calculadora = (a, b) -> a + b;
//        resultado = calculadora.operar(num1, num2);
//        System.out.println("Reslutado de la suma: " + resultado);
//
//
//        calculadora = (a, b) -> a - b;
//        resultado = calculadora.operar(num1, num2);
//        System.out.println("Reslutado de la resta: " + resultado);
//
//
//        calculadora = (a, b) -> (a - b * 2) * a / b - (b * b);
//        resultado = calculadora.operar(num1, num2);
//        System.out.println("Reslutado de la operacion de combinada: " + resultado);


        List<Integer> original = new ArrayList<>();
        List<Integer> doble;
        List<Integer> pares;
        for (int i = 0; i < 100; i++) {
            original.add(i);
        }

        int sumatoria = original.stream().reduce(0,(c, n) -> c + n);
        int sumatoria2 = original.stream().reduce(0, Integer::sum);

        System.out.println("Sumatoria: " + sumatoria2);
    /*
       for (Integer numero : original) {
            nueva.add( numero * 2);
        }
    */
        doble = original.stream().map(n -> n * 2).toList();
        pares = original.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(original);
        System.out.println(doble);
        System.out.println(pares);


        original.stream().forEach(n -> System.out.print(n+ " "));
        System.out.println("\n");
        original.parallelStream().forEach(n -> System.out.print(n+ " "));


    }

}
