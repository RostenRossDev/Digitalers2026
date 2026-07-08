package Digitalers.clase8.integrador;

import Digitalers.clase8.integrador.excepciones.AccountNotFoundException;
import Digitalers.clase8.integrador.excepciones.InsufficientFundsException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Integrador {
    //Simula base de datos
    static List<Cliente> clientes = new ArrayList<>();
    static List<Cuenta> cuentas = new ArrayList<>();
    static List<Movimiento> movimientos = new ArrayList<>();

    static Integer[] tokens = new Integer[2];
    static int proximoIndice = 0;

    static public Integer tokenInput;
    static String usuarioInput;
    static String passInput;

    static void main() {
        init();

        Scanner sc = new Scanner(System.in);
        showHomeMenu(sc);
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

    public static Cliente isUserDataValid(String user, String pass, int token){

        //PROGRAMACION FUNCIONAL
       List<Cliente> clientsFilter = Integrador.clientes.stream()
               .filter(item -> item.getUsername().equals(Integrador.usuarioInput))
               .collect(Collectors.toList());

        //ACA CORTAMOS
        if (!clientsFilter.isEmpty()  &&  clientsFilter.getFirst().getPassword().equals(Integrador.passInput) &&
                Integrador.tokens[Integrador.proximoIndice - 1] == token ){
            System.out.println("Credenciales correctas, Bienvenido a su Online Banking.");
            return clientsFilter.getFirst();
        }
        return null;
    }

    public static void credentialInput(Scanner sc){
        System.out.println("Usuario: ");
        Integrador.usuarioInput = "Usuario123"; //sc.next();
        System.out.println("Contraseña: ");
        Integrador.passInput = "1234";//sc.next();
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

        showHomeMenu(sc);
    }

    public static void ingresar(Scanner sc){
        System.out.println("Bienvenido a OnlineBanking, por favor ingrese las credenciales solicitadas: ");
        Cliente client = login(sc);
        if( client != null){
            //llamar al menu de usuario
            showUserMenu(sc, client);
        } else {
            exit();
        }

    }


    public static void exit(){
        System.out.println("Finalizando programa...");
        System.exit(0);
    }

    public static void showHomeMenu(Scanner sc){
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

    public static Cliente login(Scanner sc){
        String opcion = "S";
        int count = 1; // 0
        while(opcion.equals("S")) {
            Integer token = generateToken();
            System.out.println("\u001B[1mClave Token Generada Automaticamente:\u001B[0m " + token);
            credentialInput(sc);
            Cliente validClient = isUserDataValid(usuarioInput, passInput, tokenInput);
            if (validClient != null) {
                return validClient;
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
        return null;
    }

    // scope == alcance

    public static void showUserMenu(Scanner sc, Cliente client){
        System.out.println("""
                Para hacer un deposito, ingrese --> 1.
                Para hacer un retiro, ingrese --> 2.
                Para hacer una transferencia, ingrese --> 3.
                Para ver los movimientos, ingrese --> 4.
                Para salir ingrese cualquier otro numero.""\");
                """);
        int op = sc.nextInt();

        switch (op){
            case 1 -> depositar(sc, client);
            case 2 -> extraer(sc, client);
            case 3 -> transferir(sc, client);
            case 4 -> System.out.println("movimientos");
            default -> exit();
        }
        showUserMenu(sc, client);
    }

    private static void transferir(Scanner sc, Cliente client) {
        Cuenta cuenta = showAccountsMenu(sc, client);
        BigDecimal saldoInicial =new BigDecimal(cuenta.getSaldo().doubleValue());
        BigDecimal monto = solicitarMonto(sc);
        String cbu = solicitarUsuarioDestino(sc);

        try {
            Cuenta destino = findAccount(cbu);
            Movimiento mov = new Movimiento(cuenta, saldoInicial, monto, TipoOperacion.TRANSFERENCIA);

            cuenta.transferir(monto, destino);
            BigDecimal saldoFinal = new BigDecimal(cuenta.getSaldo().doubleValue());
            mov.setMontoFinal(saldoFinal);
            mov.setOrigen(cuenta);
            mov.setDestino(destino);
            movimientos.add(mov);
            showTransaction(mov);
        } catch (InsufficientFundsException | AccountNotFoundException e){
            System.out.print("""
                    ################# WARNING ###############
                    """);
            System.out.println(e.getMessage());
            System.out.println("""
                    #########################################
                    """);
        }
    }

    private static Cuenta findAccount(String cbu) throws AccountNotFoundException{

        //Bucle for
        Cuenta foundIt = null;
        for (Cuenta cuenta : Integrador.cuentas){
            if (cuenta.getCbu().equals(cbu)){
                foundIt = cuenta;
                break;
            }
        }

        if (foundIt != null){
            return foundIt;
        }

        String message = "La cuenta con cbu %s no existe";
        throw new AccountNotFoundException(String.format(message, cbu));

        //Programacion funcional
//        Optional<Cuenta> destino = Integrador.cuentas.stream()
//                .filter(cuenta -> cuenta.getCbu().equals(cbu))
//                .findFirst();
//        if (!destino.isEmpty()){
//            return destino.get();
//        }
//        String message = "La cuenta con cbu %s no existe";
//        throw new AccountNotFoundException(String.format(message, cbu));
    }

    private static String solicitarUsuarioDestino(Scanner sc) {
        System.out.println("Ingrese el CBU:");
        int cbu = sc.nextInt();
        return String.valueOf(cbu);
    }

    public static Cuenta showAccountsMenu(Scanner sc, Cliente cliente){
        if (cliente.getCuentas().isEmpty()){
            System.out.println("Usted no posee ninguna cuenta activa para operar.");
            //lanzar error
            return null;
        } else if(cliente.getCuentas().size() < 2){
            //retornamos la cuenta por defecto, no le preguntamos la cuenta
            // sobre la que operar
            return cliente.getCuentas().getFirst();
        } else {
            //preguntamos sobre que cuenta operar
            List<Cuenta> cuentas = cliente.getCuentas();
            System.out.println("Seleccione la cuenta a utilizar:");
            String message = "Ingrese %s para usar la cuenta en %s";
            for (int i = 0; i < cuentas.size(); i++) {
                String op = String.valueOf(i +1);
                String moneda = cuentas.get(i).getMoneda().toString();
                System.out.println(String.format(message, op, moneda));
            }
            int eleccion = sc.nextInt();
            return cuentas.get(eleccion - 1);
        }
    }

    public static void depositar(Scanner sc, Cliente cliente){
        Cuenta cuenta = showAccountsMenu(sc, cliente);
        BigDecimal saldoInicial =new BigDecimal(cuenta.getSaldo().doubleValue());
        BigDecimal monto = solicitarMonto(sc);
        Movimiento mov = new Movimiento(cuenta, saldoInicial, monto, TipoOperacion.DEPOSITO);
        cuenta.depositar(monto);
        BigDecimal saldoFinal =new BigDecimal(cuenta.getSaldo().doubleValue());
        mov.setMontoFinal(saldoFinal);
        movimientos.add(mov);
        showTransaction(mov);
    }

    public static void extraer(Scanner sc, Cliente cliente){
        Cuenta cuenta = showAccountsMenu(sc, cliente);
        BigDecimal saldoInicial =new BigDecimal(cuenta.getSaldo().doubleValue());
        BigDecimal monto = solicitarMonto(sc);
        Movimiento mov = new Movimiento(cuenta, saldoInicial, monto, TipoOperacion.EXTRACCION);
        try {
            cuenta.extraer(monto);
            BigDecimal saldoFinal = new BigDecimal(cuenta.getSaldo().doubleValue());
            mov.setMontoFinal(saldoFinal);
            movimientos.add(mov);
            showTransaction(mov);
        } catch (InsufficientFundsException e){
            System.out.print("""
                    ################# WARNING ###############
                    """);
            System.out.println(e.getMessage());
            System.out.println("""
                    #########################################
                    """);
        }
    }

    private static void showTransaction(Movimiento movimiento) {




            String message = movimiento.getOperacion() != TipoOperacion.TRANSFERENCIA ? "%s %s %s en tu cuenta, saldo final %s."
                    : "%s %s %s al CBU %s, saldo final %s";
            String monedaStr = movimiento.origen.getMoneda() == Moneda.ARS ? "pesos"
                    : movimiento.origen.getMoneda() == Moneda.EUR ? "euros" : "dolares";

            String operacion = movimiento.operacion == TipoOperacion.EXTRACCION ? "Extraiste"
                    : movimiento.operacion == TipoOperacion.DEPOSITO ? "Depositaste" : "Transferiste";

            if (movimiento.getOperacion() != TipoOperacion.TRANSFERENCIA){
                System.out.println(String.format(message, operacion, movimiento.montoOperacion, monedaStr, movimiento.getMontoFinal()));
            } else {
                System.out.println(String.format(message, operacion, movimiento.montoOperacion, monedaStr, movimiento.destino.getCbu(),movimiento.getMontoFinal()));
            }

    }

    private static BigDecimal solicitarMonto(Scanner sc) {
        System.out.println("Ingrese el monto a depositar: ");
        BigDecimal amount = new BigDecimal(sc.nextDouble());
        return amount;
    }



    public static void init(){
        LocalDate birth = LocalDate.now();
        birth = birth.minusYears(35);
        birth = birth.minusMonths(3);
        birth = birth.plusDays(9);
        System.out.println(birth.toString());
        Cuenta cuenta = new Cuenta();
        Cliente cliente = new Cliente();
        cliente.setAddress("Calle siempre viva 1234");
        cliente.setCuit("20895623147");
        cliente.setEmail("correo-de-prueba@gmail.com");
        cliente.setDni("89562314");
        cliente.setUsername("Usuario123");
        cliente.setName("Nestor");
        cliente.setLastname("Cotantini");
        cliente.setBirth(birth);
        cliente.setId(Long.valueOf(Cliente.quantity));
        cliente.setPassword("1234");

        cuenta.setId(Long.valueOf(Cuenta.quantity));
        cuenta.setCbu("25851578555");
        cuenta.setMoneda(Moneda.ARS);
        cuenta.setTitular(cliente);
        cuenta.setSaldo(BigDecimal.ZERO);

        cliente.agregarCuenta(cuenta);

        clientes.add(cliente);//guardamos en la base de datos entre muchas comillas
        cuentas.add(cuenta); //guardamos en la base de datos entre muchas comillas

        //################# segundo cliente

        LocalDate birth2 = LocalDate.now();
        birth2 = birth2.minusYears(35);
        birth2 = birth2.minusMonths(3);
        birth2 = birth2.plusDays(9);
        System.out.println(birth2.toString());
        Cuenta cuenta2 = new Cuenta();
        Cliente cliente2 = new Cliente();
        cliente2.setAddress("Calle siempre viva 1234");
        cliente2.setCuit("20895623147");
        cliente2.setEmail("correo-de-prueba@gmail.com");
        cliente2.setDni("89562314");
        cliente2.setUsername("Usuario123");
        cliente2.setName("Nestor");
        cliente2.setLastname("Cotantini");
        cliente2.setBirth(birth2);
        cliente2.setId(Long.valueOf(Cliente.quantity));
        cliente2.setPassword("1234");

        cuenta2.setId(Long.valueOf(Cuenta.quantity));
        cuenta2.setCbu("789");
        cuenta2.setMoneda(Moneda.ARS);
        cuenta2.setTitular(cliente2);
        cuenta2.setSaldo(BigDecimal.ZERO);

        cliente2.agregarCuenta(cuenta2);

        clientes.add(cliente2);//guardamos en la base de datos entre muchas comillas
        cuentas.add(cuenta2); //guardamos en la base de datos entre muchas comillas


    }
}
