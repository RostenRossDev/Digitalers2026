package Digitalers.clase8.integrador;

import Digitalers.clase8.integrador.excepciones.InsufficientFundsException;

import java.math.BigDecimal;

public class Cuenta {
    public static int quantity = 0;

    private Long id;
    private String cbu;
    private Moneda moneda;
    private BigDecimal saldo;
    private Cliente titular ;

    public Cuenta() {
        Cuenta.quantity++;
    }

    public Cuenta(Long id, String numeroCuenta, Moneda moneda, Cliente titular) {
        this.id = id;
        this.cbu = numeroCuenta;
        this.moneda = moneda;
        this.titular = titular;
        this.saldo = BigDecimal.ZERO;
        Cuenta.quantity++;
    }

    public void depositar(BigDecimal monto) {
        saldo = saldo.add(monto);
    }

    public void extraer(BigDecimal monto) throws InsufficientFundsException{
        if (saldo.compareTo(monto) >= 0) {
            saldo = saldo.subtract(monto);
            return;
        }
        throw new InsufficientFundsException("Saldo Insuficiente.");
    }

    public void transferir(BigDecimal monto, Cuenta destino) throws InsufficientFundsException{
        this.extraer(monto);
        destino.depositar(monto);
    }
    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
}
