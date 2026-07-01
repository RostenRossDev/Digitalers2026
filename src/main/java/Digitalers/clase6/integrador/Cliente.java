package Digitalers.clase6.integrador;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {

    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private String cuit;
    private String address;
    private String email;
    private LocalDate birth;

    public Cliente(){}
    public Cliente(Long id, String name, String lastname, String dni, String cuit, String address, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.cuit = cuit;
        this.address = address;
        this.email = email;
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
}
