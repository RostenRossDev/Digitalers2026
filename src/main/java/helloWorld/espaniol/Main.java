package helloWorld.espaniol;

public class Main {

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
    }
}