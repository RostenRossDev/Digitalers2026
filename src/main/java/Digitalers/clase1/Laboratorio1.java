package Digitalers.clase1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Laboratorio1 {

    static void main() {
        saludo("Nestor");
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5();
        ejercicio6();
        String apellido = "Cotantini";
        saludo(apellido);
    }

    public static void saludo(String nombre){
        System.out.println("Hola " + nombre);
    }
    public static void ejercicio1(){
//  Si variableA, variableB y variableC son de tipo lógicas
//  o boolean, ¿qué valores deben poseer para que las
//  siguientes operaciones den los siguientes resultados?:
//          ● (variableA && variableB) || (variableA && variableC) = true
//          ● !(variableA || variableB) && variableC = false
        System.out.println("################### ejercicio 1");
        boolean variableA = true;
        boolean variableB = true;
        boolean variableC = false;

        System.out.println("Resultado 1: " + ( (variableA && variableB) || (variableA && variableC) ));

        variableA = true;
        variableB = false;
        variableC = true;

        System.out.println("Resultado 2: " + ( (variableA && variableB) || (variableA && variableC) ));

    }

    public static void ejercicio2(){
        System.out.println("################### ejercicio 2");

//        1. Analizar el código a continuación y completar la tabla correspondiente.
//        2. A continuación, realizar la codificación para confirmar que ha completado la tabla de forma correcta.

        System.out.println("########### A");
        String palabra_1 ="Hola";
        String palabra_2 ="Mundo";
        String frase = "";
        System.out.println(palabra_1);
        System.out.println(palabra_2);
        System.out.println(frase);
        
        System.out.println("########### B");
        frase =palabra_1+palabra_2;
        System.out.println(palabra_1);
        System.out.println(palabra_2);
        System.out.println(frase);

        System.out.println("########### C");
        frase =palabra_1+" \t "+palabra_2;
        System.out.println(palabra_1);
        System.out.println(palabra_2);
        System.out.println(frase);


        System.out.println("########### D");
        frase =palabra_1 + " \n " + palabra_2;
        System.out.println(palabra_1);
        System.out.println(palabra_2);
        System.out.println(frase);

        System.out.println("###########E");
        frase =palabra_1 + " \n \t " + palabra_2;
        System.out.println(palabra_1);
        System.out.println(palabra_2);
        System.out.println(frase);

    }

    public static void ejercicio3(){
        System.out.println("################### ejercicio 3");

//        1. Analizar el código que sigue y completar la tabla correspondiente.
//        2. Luego, realizar la codificación para confirmar que ha completado la tabla correctamente.

        System.out.println("A");
        boolean n1 = true;
        boolean n2 = false;
        boolean n3 = !n1;  //false
        boolean n4 = !n2; //true
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println("B");
        n3 = n1 & n2; // false
        n4 = n1 | n2; // true
        System.out.println(n3);
        System.out.println(n4);
    }

    public static void ejercicio4(){
        System.out.println("################### ejercicio 4");

//        1. Resolver los enunciados desarrollando el código.
//        2. Dados n1=true, n2=false y n3=true, informar:
//        a) n1 ^ n2 --> No tiene solucion ya que no existe la operacion ^ en java.
//        b) (n1 & !n2) | n3
//        c) (n1 | n2) & !n3

        boolean n1=true;
        boolean n2=false;
        boolean n3=true;

        System.out.println("########### b");
        boolean resultadoB =  (n1 & !n2) | n3;  // (true & !(false)) | true  ==> (true & true) | true ==> true | true ==> true
        System.out.println("resultadoB: " + resultadoB);

        System.out.println("########### c");
        boolean resultadoC =  (n1 | n2) & !n3; //(true | false) & !true  ==> true & false ==> false
        System.out.println("resultadoC: " + resultadoC);
    }

    public static void ejercicio5(){
        System.out.println("################### ejercicio 5");
//        1. Resolver los enunciados desarrollando el código.
//        2. Declarar dos variables n1=5 y n2=10.
//        3. Utilizando concatenación entre las variables y los literales, mostrar en pantalla la siguiente expresión:
//        a) n1 es igual a 5.
//        b) n2 es igual a 10.
//        c) n1 más n2 es igual a 15
        byte n1=5;
        byte n2=10;
        System.out.println("########### a");
        boolean resA = n1 == 5;  // True
        System.out.println("resA: " + resA);

        System.out.println("########### b");
        boolean resB = n2 == 10; // True
        System.out.println("resB: " + resB);

        System.out.println("########### c");
        boolean resC = (n1 + n2) == 15; //true
        System.out.println("resC: " + resC);


    }

    public static void ejercicio6(){
        System.out.println("################### ejercicio 6");
//        Haciendo uso de la constante IVA=21, calcular
//        el precio con IVA de los siguientes productos
//        e informar:
//        a) remera:59.90$
//        b) pantalón:99.90$
//        c) campera:149.90$

//miValor * ivaPorcentaje
        final int IVA = 21;
        final double IVA_PORCENTAJE = IVA / 100.00;
        double remera = 59.90d;
        double pantalon = 99.90d;
        double campera = 149.90d;
        //#### a)

        double remeraFinal = remera + ( remera * IVA_PORCENTAJE);
        System.out.println("Iva de la remera: " + (remera * IVA_PORCENTAJE));
        BigDecimal remeraFinalRedondeada = new BigDecimal(remera * IVA_PORCENTAJE);
        System.out.println("Precio final de la remera: " + remeraFinalRedondeada.setScale(2, RoundingMode.HALF_UP));

        //#### a)

        double pantalonFinal = pantalon + ( pantalon * IVA_PORCENTAJE);
        System.out.println("Iva de la pantalon: " + (pantalon * IVA_PORCENTAJE));
        BigDecimal pantalonFinalRedondeada = new BigDecimal(pantalon * IVA_PORCENTAJE);
        System.out.println("Precio final de la pantalon: " + pantalonFinalRedondeada.setScale(2, RoundingMode.HALF_UP));

        //#### a)
        double camperaFinal = campera + ( campera * IVA_PORCENTAJE);
        System.out.println("Iva de la campera: " + (campera * IVA_PORCENTAJE));
        BigDecimal camperaFinalRedondeada = new BigDecimal(campera * IVA_PORCENTAJE);
        System.out.println("Precio final de la campera: " + camperaFinalRedondeada.setScale(2, RoundingMode.HALF_UP));
    }
}
