package Digitalers.clase6.interfases;

import Digitalers.clase6.herencia.Cuadrado;
import Digitalers.clase6.herencia.Triangulo;
import Digitalers.clase6.integrador.Cliente;

public class clase6_2 {
    static void main() {

        int numero = 52;
        Triangulo triangulito = new Triangulo(3.0,1.5,4.2);
        Cuadrado cuadrito = new Cuadrado(3.0);

        System.out.println(triangulito);
        System.out.println(cuadrito);

        Cuadrado cuadradote = cuadrito;

        System.out.println(cuadradote);
        System.out.println("cuadradote lado: " + cuadradote.getLado1());

        cuadradote.setLado1(52);

        System.out.println("cuadradote lado actualizado: " + cuadradote.getLado1());

        System.out.println("cuadrito lado: " + cuadrito.getLado1());

        cuadradote = new Cuadrado(52.0);

        System.out.println(cuadradote);

        System.out.println("Clientes actuales: " + Cliente.quantity);

        Cliente cliente  = new Cliente(null,null,null,null,null,null,null);
        System.out.println("Clientes actuales: " + Cliente.quantity);
        Cliente cliente2  = new Cliente(1L,"nestor","Costantini",null,null,null,null);

        System.out.println("apellido del cliente 1: " + cliente.getLastname());
        System.out.println("apellido del cliente 2: " + cliente2.getLastname());

        System.out.println("Clientes actuales: " + Cliente.quantity);


        /*
        Equipo ballenita = new Equipo(BALLENITA);
        Jugador matias = new Jugador(Matias);

        ballenita.agregarJugador(matias);

        ballenita = new Equipo(Lobos);

        sout(matias.getName())

        matias = null;

        sout(ballenita.getName()) -->> Lobos

        Automovil colectivo = new Automovil(colectivo);

        Motor motor = colectivo.getMotor();
        motor ---x---> automovil

        sout(colectivo.getMotor().getMarca()) ---> bajaj

        automovil ----> motor.

        colectivo = new Automovil();

        sout(colectivo.getMotor().getMarca()) ---> BMW

        motor = null;

        * */

    }
}
