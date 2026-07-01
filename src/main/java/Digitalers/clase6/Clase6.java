package Digitalers.clase6;

import Digitalers.clase6.herencia.Cuadrado;
import Digitalers.clase6.herencia.FiguraGeometrica;
import Digitalers.clase6.herencia.Triangulo;
import Digitalers.clase6.herenciaEInterfases.TrianguloConHerenciaEInterfaz;
import Digitalers.clase6.integrador.Cliente;

import java.time.LocalDate;

public class Clase6 {
    static void main() {

        LocalDate now = LocalDate.now();
        LocalDate birth = LocalDate.now()
                .minusYears(25)
                .minusMonths(3)
                .minusDays(10);
        System.out.println(birth);
        Cliente client = new Cliente();
        client.setBirth(birth);
        System.out.println(client.calcularEdad());

//        double a = 0.1;
//        double b = 0.2;
//        double c = a + b;
//        System.out.println(c); // 0.30000000000000004
//        System.out.println(c == 0.3); // false
//        SuperPersona batman = new SuperPersona();
//
//        SuperPersona superman = new SuperPersona("Superman");
//
//        try {
//            batman.setNombre("Bruce wayne");
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            batman.setNombre(null);
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        batman.nombre = "Yo soy BATMAN!!";  //Si tiene le modificador de acceso por defecto, el atributo
// accesible desde cualquier clase que este en el mismo paquete.

//        int b = 0;
//        try{ //codigo del flujo esperrado/bueno/correcto
//            int a;
//            if (b == 3) {
//                throw new NoEsDivisiblePorTresException("Falla al dividir por 3.");
//            }
//            a = 5/b;
//        } catch (NoEsDivisiblePorTresException e) { //En caso de que el flujo esperado falle
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//        dividir();
//        dividir();
//        leerArchivo();
//
//        try {
//            dividir();
//            leerArchivo();
//        } catch (ErrorDeLecutraException e) {
//            System.out.println(e.getMessage());
//        } catch (NoEsDivisiblePorTresException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println("Liberando recursos");
//        }

        Object obj = new Object();

//        FiguraGeometrica figuraGeometrica = new FiguraGeometrica();  // Es una clase ABSTRACTA la cual no se puede instanciar.

        Triangulo triangulito = new Triangulo(3.0,1.5,4.2);
        Cuadrado cuadrito = new Cuadrado(3.0);

        Double areaTriangulo = triangulito.calcularArea();
        Double perimetroTriangulo = triangulito.calcularPerimetro();
        System.out.println("El area del triangulo es: " + areaTriangulo);
        System.out.println("El perimetro del triangulo es: " + perimetroTriangulo);


        Double areaCuadrado = cuadrito.calcularArea();
        Double perimetroCuadrado = cuadrito.calcularPerimetro();
        System.out.println("El area del Cuadrado es: " + areaCuadrado);
        System.out.println("El perimetro del Cuadrado es: " + perimetroCuadrado);



        TrianguloConHerenciaEInterfaz triangulitoConHerenciaEInterfaz = new TrianguloConHerenciaEInterfaz(3.0,1.5,4.2);
        Double areaTrianguloConHerenciaEInterfaz = triangulitoConHerenciaEInterfaz.calcularArea();
        Double perimetroTrianguloConHerenciaEInterfaz = triangulitoConHerenciaEInterfaz.calcularPerimetro();
        System.out.println("El area del triangulo es: " + areaTrianguloConHerenciaEInterfaz);
        System.out.println("El perimetro del triangulo es: " + perimetroTrianguloConHerenciaEInterfaz);

    }

    static public void leerArchivo() throws ErrorDeLecutraException {
        System.out.println("Lellendo el archivo ....");
        throw new ErrorDeLecutraException("""
                El archivo "C://.../" no existe""");
    }

    static public void dividir() throws NoEsDivisiblePorTresException {
        System.out.println("Dividiendo ....");
//        throw new NoEsDivisiblePorTresException("No es posible dividir por 3");
    }
}
