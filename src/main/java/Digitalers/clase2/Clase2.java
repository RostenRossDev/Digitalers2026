package Digitalers.clase2;

import java.util.Scanner;

public class Clase2 {
    static void main() {

        //##### Clase Escaner (Scanner) para interactuar mediante el teclado.
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba su nombre: ");
//        String nombre = sc.nextLine();
//        System.out.println("Hola " + nombre);

        System.out.println("¿Qué edad tenes?");

//        int edad = sc.nextByte();
//
//        System.out.println("aaah sos mayor edad!.");


        //################# Casteo (Casting  )

        byte miNumerito = 35; //127  o -128
        short miNumero = 1; //32767;
        int miSuma = miNumerito + miNumero;
        short miNumeritoPeroEnUnShort = miNumerito;

        char caracter = 'o';
        int letraOEnEntero = caracter;
        System.out.println("La letra \"o\" equivale a " + letraOEnEntero);

        int letraOEnNumero = 111;
        char caracterO = (char) letraOEnNumero;


        String texto = "Hola alumnos, bienvenidos a la clase de java";
        String letra = "a";
        boolean contiene = texto.contains("a");
        System.out.println("La letra existe : " + contiene);

        boolean contieneFrase = texto.contains("la clase");
        System.out.println("La frase 1 : " + contieneFrase);

        boolean contieneFrase2 = texto.contains("es lunes");
        System.out.println("La la frase 2 : " + contieneFrase2);

        String te = "te";
        String te2 = "Te";
        System.out.println("Frases distintas : " + te.equals(te2));

        System.out.println("Frases distintas con ignore case: " + te.equalsIgnoreCase(te2));


        int id = 1;
        String sistema = "mec";
        int tiempo = 77777;

        String mensaje = "El id " + id + " del usuario no existe en el sistema " + sistema +
                " intente nuevamente en " + tiempo + " segundos.";

        String mensajeConFormato = "El id %d del usuario no existe en el sistema %s intente nuevamente en %d segundos.";

        System.out.println(mensaje);

        System.out.println(String.format(mensajeConFormato, id, sistema, tiempo));

        System.out.println("En la posicion de la letra 'o': " + mensajeConFormato.indexOf(111));

        String palabraNula = null;
        String palabraVacia = "";
        String palabraNoVacia = " ";

//        palabraNula.isEmpty();
        System.out.println("Esta vacia ?? : " + palabraVacia.isEmpty());
        System.out.println("Esta vacia ?? : " + palabraNoVacia.isEmpty());

        String joinResultado = String.join("-", "Juan", "Pedro", "María");

        System.out.println(joinResultado);

        System.out.println("La ultima posicion de la letra 'o': " + mensajeConFormato.lastIndexOf(111));
        System.out.println("La ultima posicion de la letra \"o\": " + mensajeConFormato.lastIndexOf("o"));
        System.out.println("La longitud de mi texto es de : " + mensajeConFormato.length());
        System.out.println("##############################################");
        System.out.println("Texto original: " + mensajeConFormato);
        System.out.println(mensajeConFormato.replace("del usuario", "de la persona"));

        System.out.println(mensajeConFormato.toLowerCase());
        System.out.println(mensajeConFormato.toUpperCase());

        String numToString = String.valueOf(23);
        String booleanToString = String.valueOf(false);
        String charToString = String.valueOf('c');
        String floatToString = String.valueOf(15.5f);
        System.out.println(numToString + ", " + booleanToString + ", " + charToString + ", " + floatToString);
        //obj==obj2   compara POSICION DE MEMORIA
        //obj.equals(obj2)  compara el CONTENIDO de los objetos


        //######################  MATH

        int absoluto = Math.abs(-10);
        System.out.println("Abosulto de -10 = " + absoluto);

        //############ Operaciones TRIGONOMETRICAS

        double arcoCoseno = Math.acos(-0.5);
        System.out.println("Arco coseno de -0.5 = " + arcoCoseno);

        double coseno = Math.cos(-0.5);
        System.out.println("Coseno de -0.5 = " + coseno);

        double seno = Math.sin(-0.5);
        System.out.println("Seno de -0.5 = " + seno);

        double arcoSeno = Math.asin(-0.5);
        System.out.println("Arco seno de -0.5 = " + arcoSeno);

        double tangente = Math.tan(-0.5);
        System.out.println("tangente de -0.5 = " + tangente);

        double aTan = Math.atan(-0.5);
        System.out.println("Arco tangente de -0.5 = " + aTan);

        int addExact = Math.addExact(3 , 1);
        System.out.println("addExact de 3 Y 1 = " + addExact);

        // Raices

        double raiz = Math.sqrt(25);
        System.out.println("Raiz cuadrada de 25 = " + raiz);

        double raiz1 = Math.cbrt(27);

        System.out.println("Raiz cubica de 27 = " + raiz1);

        double raiz2 = Math.cbrt(28);

        System.out.println("Raiz cubica de 28 = " + raiz2);

        // Potencias
        double potencia = Math.pow(2, 3);
        System.out.println("potencia de 2 al cubo = " + potencia);

        double eulerPotencia = Math.exp(2);
        System.out.println("Euler al cuadrado = " + eulerPotencia);

        // logaritmos

        double logaritmoNatural = Math.log(2);
        System.out.println("logaritmo en base E (logaritmo natural) = " + logaritmoNatural);


        double logaritmoEnBase10 = Math.log10(2);
        System.out.println("logaritmo en base 10 = " + logaritmoEnBase10);
    }
}
