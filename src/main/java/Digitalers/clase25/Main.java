package Digitalers.clase25;

import Digitalers.clase25.daos.impl.AlumnoDaoImpl;
import Digitalers.clase25.entities.Alumno;
import Digitalers.clase25.entities.Persona;

import java.sql.SQLException;

public class Main {
    static void main() {
        AlumnoDaoImpl alumnoDao = new AlumnoDaoImpl();

        Alumno a = new Alumno( "Matias", "Fafafa", "12345679", "Calle siempre viva 1234", "3624123456", "costantini1.nestor.m@gmail.com");
        System.out.println(a);
        try {
            alumnoDao.insertar(a);
            System.out.println("Esperando ....");
            Long legajo = 6488L;
            Alumno a2 = alumnoDao.buscarPorLegajo(legajo);
            System.out.println(a2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
