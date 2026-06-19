package Digitalers.clase5;

import java.util.Scanner;

public class Integrador {

    /**
     * ● La Clave Token debe ser un número aleatorio de 6 dígitos
     * ● El cliente debe ingresar los campos Usuario, Contraseña y Clave Token (todos obligatorios).
     * ● El campo Usuario no distingue minúsculas o mayúsculas.
     * ● El campo Contraseña es sensible a las minúsculas y mayúsculas.
     * ● El cliente solo posee 3 intentos de logueo. Si alcanza los 3 intentos fallidos de forma consecutiva, la aplicación deberá informar al
     * usuario que debe dirigirse a la sucursal delbanco más cercana para poder desbloquear sus credenciales.
     * ● Por cada intento fallido, la aplicación debe preguntar al cliente si desea continuar colocando las credenciales de manera
     * correcta.
     * ● Si el cliente coloca las credenciales de forma correcta, deberá informar que ha ingresado correctamente al Online Banking.
     */

    static void main() {

        Scanner sc = new Scanner(System.in);
        String usuario = "administrador";
        String pass = "administrador.1234";

        //Generar el numero random
        final Integer MAX_VALUE = 999999;
        final Integer MIN_VALUE = 111111;
        final Integer DELTA = 999999 - 111111;

        System.out.println("Bienvenido a OnlineBanking, por favor ingrese las credenciales solicitadas: ");


        String opcion = "S";
        int count = 0;
        while(opcion.equals("S")) {
            Integer token = (int) (Math.random() * (DELTA + 1) + MIN_VALUE);
            System.out.println("\u001B[1mClave Token Generada Automaticamente:\u001B[0m " + token);

            System.out.println("Usuario: ");
            String userInput = sc.nextLine();
            System.out.println("Contraseña: ");
            String passInput = sc.nextLine();
            System.out.println("Clave Token: ");
            Integer tokenInput = Integer.valueOf(sc.nextLine());

            if (usuario.equalsIgnoreCase(userInput) && pass.equals(passInput)
                    && token.equals(tokenInput)) {
                System.out.println("Credenciales correctas, Bienvenido a su Online Banking.");
                //opcion = "N";
                break;
            } else {
                if (count > 3) {
                    System.out.println("Error de credenciales... Usuario Bloqueado, por favor dirijase a la sucursal mas cercana.");
                    break;
                } else {
                    System.out.println("Error de credenciales... Desea intentarlo nuevamente? (S/N): ");
                    opcion = sc.next();
                    count++;
                }
            }
        }
    }
}
