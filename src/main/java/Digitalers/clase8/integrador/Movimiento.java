package Digitalers.clase8.integrador;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Movimiento {
    LocalDateTime fechaCreacion;
    TipoOperacion operacion;
    BigDecimal montoOperacion;
    BigDecimal montoInicial;
    BigDecimal montoFinal;
    Cuenta origen;
    Cuenta destino;

    public Movimiento(){
        this.fechaCreacion = LocalDateTime.now();

    }

    public Movimiento(Cuenta origen, BigDecimal montoInicial, BigDecimal montoOperacion, TipoOperacion operacion){
        this.fechaCreacion = LocalDateTime.now();
        this.origen = origen;
        this.montoOperacion = montoOperacion;
        this.montoInicial = montoInicial;
        this.operacion = operacion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public TipoOperacion getOperacion() {
        return operacion;
    }

    public void setOperacion(TipoOperacion operacion) {
        this.operacion = operacion;
    }

    public BigDecimal getMontoOperacion() {
        return montoOperacion;
    }

    public void setMontoOperacion(BigDecimal montoOperacion) {
        this.montoOperacion = montoOperacion;
    }

    public BigDecimal getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(BigDecimal montoInicial) {
        this.montoInicial = montoInicial;
    }

    public BigDecimal getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(BigDecimal montoFinal) {
        this.montoFinal = montoFinal;
    }

    public Cuenta getOrigen() {
        return origen;
    }

    public void setOrigen(Cuenta origen) {
        this.origen = origen;
    }

    public Cuenta getDestino() {
        return destino;
    }

    public void setDestino(Cuenta destino) {
        this.destino = destino;
    }
}
