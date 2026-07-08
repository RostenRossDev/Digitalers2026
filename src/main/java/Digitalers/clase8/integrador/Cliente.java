package Digitalers.clase8.integrador;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static int quantity = 0;

    private Long id;
    private String username;
    private String name;
    private String lastname;
    private String dni;
    private String cuit;
    private String address;
    private String email;
    private String password;
    private LocalDate birth;
    private List<Cuenta> cuentas; // =  new ArrayList<>();

    public Cliente(){
        this.cuentas =  new ArrayList<>();
        Cliente.quantity++;
    }

    public Cliente(Long id, String name, String lastname, String dni, String cuit, String address, String email, String password, String username) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.cuit = cuit;
        this.address = address;
        this.email = email;
        this.password = password;
        this.username = username;
        this.cuentas =  new ArrayList<>();
        Cliente.quantity++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Integer calcularEdad(){
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public boolean agregarCuenta(Cuenta cuenta){
        boolean existe = cuentas.stream()
                .anyMatch(c -> c.getMoneda() == cuenta.getMoneda());

        if (existe) {
            return false;
        }

        cuentas.add(cuenta);
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void eliminarCuenta(Cuenta cuenta){
        this.cuentas.remove(cuenta);
    }

    public void eliminarCuenta(int indice){
        this.cuentas.remove(indice);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
