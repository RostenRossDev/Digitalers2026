package Digitalers.clase8.integrador;

import java.math.BigDecimal;

public class Cuenta {
    private Long id;
    private String numeroCuenta;
    private Moneda moneda;
    private BigDecimal saldo;
    private Cliente titular ;

    public Cuenta() {
    }

    public Cuenta(Long id, String numeroCuenta, Moneda moneda, Cliente titular) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.moneda = moneda;
        this.titular = titular;
        this.saldo = BigDecimal.ZERO;
    }

    public void depositar(BigDecimal monto) {
        saldo = saldo.add(monto);
    }

    public boolean extraer(BigDecimal monto) {
        if (saldo.compareTo(monto) >= 0) {
            saldo = saldo.subtract(monto);
            return true;
        }
        return false;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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
