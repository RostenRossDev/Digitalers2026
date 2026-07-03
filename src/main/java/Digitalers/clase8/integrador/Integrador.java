package Digitalers.clase8.integrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Integrador {
    //Simula base de datos
    static List<Cliente> clientes = new ArrayList<>();
    static List<Cuenta> cuentas = new ArrayList<>();

    static Integer[] tokens = new Integer[2];
    static int proximoIndice = 0;

    static public Integer tokenInput;
    static String usuarioInput;
    static String passInput;

    static void main() {

        Scanner sc = new Scanner(System.in);
        showMenu(sc);




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

        //PROGRAMACION FUNCIONAL
       List<Cliente> clientsFilter = Integrador.clientes.stream()
               .filter(item -> item.getUsername().equals(Integrador.usuarioInput))
               .collect(Collectors.toList());

        //ACA CORTAMOS
        if (!clientsFilter.isEmpty()  &&  clientsFilter.getFirst().getPassword().equals(Integrador.passInput) &&
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

    public static Cliente registerInput(Scanner sc){
        System.out.println("Ingrese su nombre: ");
        String name = sc.next();

        System.out.println("Ingrese su apellido: ");
        String lastname = sc.next();

        System.out.println("Ingrese su nombre de usuario: ");
        String username = sc.next();

        System.out.println("Ingrese su cuit: ");
        String cuit = sc.next();

        System.out.println("Ingrese su dni: ");
        String dni = sc.next();

        System.out.println("Ingrese su dirección: ");
        String addres = sc.next();

        System.out.println("Ingrese su correo: ");
        String email = sc.next();

        System.out.println("Ingrese una Contraseña: ");
        String pass = sc.next();
        Long id = (long) (Integrador.clientes.size() + 1);
        return new Cliente(id, name, lastname, dni, cuit, addres, email, pass, username);
    }

    public static boolean saveClient(Cliente client){
        return Integrador.clientes.add(client);
    }

    public static void registrar(Scanner sc){
        Cliente newClient = registerInput(sc);
        if (saveClient(newClient)){
            System.out.println("Se a registrado con exito.");
        } else {
            System.out.println("Ups! Ocurrio un error, intente nuevamente mas tarde.");
        }

        showMenu(sc);
    }

    public static void ingresar(Scanner sc){
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


    public static void exit(){
        System.out.println("Finalizando programa...");
        System.exit(0);
    }

    public static void showMenu(Scanner sc){
        System.out.println("""
        Para ingresar 1.
        Para registrarse 2.
        Para salir ingrese cualquier otro numero.""");
        int op = sc.nextInt();

        switch (op){
            case 1 -> ingresar(sc);
            case 2 -> registrar(sc);
            default -> exit();
        }
    }
}
