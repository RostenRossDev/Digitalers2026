package Digitalers.clase6.integrador;

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
    static Integer[] tokens = new Integer[2];
    static int proximoIndice = 0;
    static String usuario = "administrador";
    static String pass = "administrador.1234";

    static public Integer tokenInput;
    static String usuarioInput;
    static String passInput;

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a OnlineBanking, por favor ingrese las credenciales solicitadas: ");
        String opcion = "S";
        int count = 1; // 0
        while(opcion.equals("S")) {
            Integer token = generateToken();
            System.out.println("\u001B[1mClave Token Generada Automaticamente:\u001B[0m " + token);
            credentialInput(sc);
            if (isUserDataValid(usuarioInput, passInput, tokenInput)) {
                break;
            } else {
                if (count == 3 /*2*/) {
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

    //Generar el numero random
    public static int generateToken(){
        final Integer MAX_VALUE = 999999;
        final Integer MIN_VALUE = 111111;
        final Integer DELTA = 999999 - 111111;
        int token = (int) (Math.random() * (DELTA + 1) + MIN_VALUE);
        //validar que exista
        if(!isRepeated(token)){
            if (Integrador.proximoIndice < 2){
                Integrador.tokens[Integrador.proximoIndice] = token;
                Integrador.proximoIndice++;
            }
        } else {
            generateToken();
        }
        // repetimos el proceso
        return token;
    }

    //Verifica que el token no sea repetido
    public static boolean isRepeated(int token){
        for (int i = 0; i < ( Integrador.proximoIndice); i++) {
            if(Integrador.tokens[i] == token){
                return Boolean.TRUE;   // return true
            }
        }
        return Boolean.FALSE;
    }

    public static boolean isUserDataValid(String user, String pass, int token){
        if (Integrador.usuario.equalsIgnoreCase(user) &&  Integrador.pass.equalsIgnoreCase(pass) &&
                Integrador.tokens[Integrador.proximoIndice - 1] == token ){
            System.out.println("Credenciales correctas, Bienvenido a su Online Banking.");
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static void credentialInput(Scanner sc){
        System.out.println("Usuario: ");
        Integrador.usuarioInput = sc.next();
        System.out.println("Contraseña: ");
        Integrador.passInput = sc.next();
        System.out.println("Clave Token: ");
        Integrador.tokenInput = Integer.valueOf(sc.next());
    }
}
