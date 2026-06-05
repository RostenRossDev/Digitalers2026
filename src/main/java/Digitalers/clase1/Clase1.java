package Digitalers.clase1;

public class Clase1 {

    static void main() {

        //Pritivos NUMERICOS enteros
        long enteroMuyGrande = 100;
        int entero = 30;
        short enteroPequenio = 25;
        byte enteroMuyPequenio = 2;

        //Pritivos NUMERICOS decimales
        float decimal = 10.5f;
        double decimalDeMayorPresicion = 10.55d;

        //Primitivo logico
        boolean esVerdadero = false;  // true

        //Primitivo de caracter
        char caracter = 'H';
        //Objeto Cadena-palabra
        String palabra = "Hola";

        Long objetoEnteroMuyGrandePositivo = Long.MAX_VALUE;
        Long objetoEnteroMuyGrandeNegativo = Long.MIN_VALUE;


        IO.println(objetoEnteroMuyGrandePositivo);
        IO.println(objetoEnteroMuyGrandeNegativo);


        Integer objetoEnterodePositivo = Integer.MAX_VALUE;
        Integer objetoEnteroNegativo = Integer.MIN_VALUE;


        IO.println("Integer :" + objetoEnterodePositivo);
        IO.println("Integer :" + objetoEnteroNegativo);

        Short objetoEnteroPequenioPositivo = Short.MAX_VALUE;
        Short objetoEnteroPequenioNegativo = Short.MIN_VALUE;


        IO.println("Short" + objetoEnteroPequenioPositivo);
        IO.println("Short" + objetoEnteroPequenioNegativo);

        Byte objetoEnteroMuyPequenioPositivo = Byte.MAX_VALUE;
        Byte objetoEnteroMuyPequenioNegativo = Byte.MIN_VALUE;


        IO.println("Byte" + objetoEnteroMuyPequenioPositivo);
        IO.println("Byte" + objetoEnteroMuyPequenioNegativo);



        Float flotantePositivo = Float.MAX_VALUE;
        Float flotanteNegativo = Float.MIN_VALUE;


        IO.println("Float" + flotantePositivo);
        IO.println("Float" + flotanteNegativo);

        Double DoubleePositivo = Double.MAX_VALUE;
        Double DoubleNegativo = Double.MIN_VALUE;


        IO.println("Double" + DoubleePositivo);
        IO.println("Double" + DoubleNegativo);


        Boolean booleanWrapper = false;
        Boolean booleanWrapper2 = Boolean.FALSE;
        Boolean booleanWrapper3 = Boolean.TRUE;

        char charcter = '\uFFFF';
        Character caracter2 = new Character ('\u0040');

        System.out.println("Chacter: " + charcter);
        System.out.println("ChacterWrapper: " + caracter2);

        System.out.println( (int) charcter ); // 64

        System.out.println("letra:" + charcter);
        System.out.println(charcter + 1);   // 65
        System.out.println((char) (charcter + 1)); //


        // Constantes


        int miNumero = 5;
        int miSegundoNumero;

        final int MI_CONSTANTE = 10;
        final int MI_SEGUNDA_CONSTANTE;
        MI_SEGUNDA_CONSTANTE = 0;


        //Operadores matematicos

        //+    -   *    /   %

        //(Suma)
        int g = 10;
        int h = 3;
        float suma = g+h;
        System.out.println("Suma: " + suma);

        //(resta)
        int i = 10;
        int j = 3;
        float resta = j-i;
        System.out.println("resta: " + resta);

        //(Division)
        //#La division entre enteros siempre da un resultado entero. Para hacer una division entre Reales solo basta con que uno sea
        // un numero real.
        float c = 10.f;
        int b = 3;
        float division = b/c;
        System.out.println("division: " + division);

        //(Multiplicacion)
        float d = 10.f;
        int f = 3;
        float multiplicacion = d*f;
        System.out.println("multiplicacion: " + multiplicacion);

        //(Modulo) El resto de una division.
        float k = 6.f;
        int l = 4;
        float modulo = c%b;
        float modulo2 = k%l;
        System.out.println("modulo: " + modulo);
        System.out.println("modulo2: " + modulo2);


        // (Concatenacion) Para operar con palabras

        String nombre = "Nestor Matias";
        String apellido = " Costantini";

        String nombreYApellido = nombre + apellido;

        System.out.println("nombreYApellido: " + nombreYApellido);
        System.out.println("concatenar forma 2: " + nombre.concat(apellido));

        //operacion con Booleanos

//        (operacion and)
//        0 * 0  = 0
//        1 * 1  = 1
//        1 * 0  = 0
//        0 * 1  = 0
        Boolean miVerdad = true;
        Boolean miVerdad2 = true;
        Boolean miFalso = false;
        Boolean miFalso2 = false;

        System.out.println("VERDADERO & VERDADERO = " + (miVerdad && miVerdad2));
        System.out.println("VERDADERO & FALSO = " + (miVerdad && miFalso));
        System.out.println("FALSO & FALSO = " + (miFalso2 & miFalso));
        System.out.println("VERDADERO & VERDADERO & VERDADERO & FALSO = " + (true && false && true && true)); // Con que haya un solo falso anula toda la operacion y el resultado tiene el valor de FALSO


//        (operacion or)
//        0 + 0  = 0
//        1 + 1  = 1
//        1 + 0  = 1
//        0 + 1  = 1
        System.out.println("########################### operacion OR");
        System.out.println("VERDADERO || VERDADERO = " + (miVerdad | miVerdad2));
        System.out.println("VERDADERO || FALSO = " + (miVerdad || miFalso));
        System.out.println("FALSO | VERDADERO = " + (miFalso | miVerdad));
        System.out.println("FALSO || FALSO = " + (miFalso2 | miFalso));
        System.out.println("VERDADERO || VERDADERO * VERDADERO * FALSO = " + (false || false || true || false)); // Con que haya un solo falso anula toda la operacion y el resultado tiene el valor de FALSO


//        Operaciones bit a bit
//
//        Con números enteros, | y & trabajan sobre los bits:

        int numero1 = 5;  // 0101
        int numero2 = 3;  // 0011

        System.out.println( "5 & 3 = " + (numero1 & numero2)); // 1 (0001)
        System.out.println( "5 | 3 = " + (numero1 | numero2)); // 7 (0111)
    }
}