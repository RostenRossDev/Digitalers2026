package Digitalers.clase21;

import Digitalers.clase21.test1.Auto;
import Digitalers.clase21.test1.Color;
import Digitalers.clase21.test1.Vehiculo;

public class Main {

    static void main() {
        Auto auto1 = new Auto();
        Auto auto2 = new Auto();
        Auto auto3 = new Auto();
        /* .......*/
        Auto auto1000 = new Auto();

        System.out.println(auto2.getColor());

        Vehiculo miVehiculo = auto2;

        System.out.println(miVehiculo.getPatente());
        System.out.println(auto2.getColor());


        System.out.println(Color.AZUL.getHex());
        System.out.println(Color.AZUL.getName());
    }
}
