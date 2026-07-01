package Digitalers.clase6.interfases;

import Digitalers.clase6.herencia.FiguraGeometrica;

public class CuadradoConInterfaz implements IFiguraGeometrica {
    // atributos
    private Double lado;

    //constructores
    public CuadradoConInterfaz(Double lado1){
        this.lado = lado1;
    }


    //getters y setters
    public Double getLado() {
        return lado;
    }

    public void setLado(Double lado) {
        this.lado = lado;
    }

    //metodos genericos
    @Override
    public Double calcularArea() {
        return lado*lado;
    }

    @Override
    public Double calcularPerimetro() {
        return lado*4;
    }
}
