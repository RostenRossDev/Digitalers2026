package Digitalers.clase6.interfases;

import Digitalers.clase6.herencia.FiguraGeometrica;

public class TrianguloConInterfaz implements IFiguraGeometrica  {
    private Double lado1;
    private Double lado2;
    private Double lado3;
    public TrianguloConInterfaz(Double lado1, Double lado2, Double lado3){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public Double getLado1() {
        return lado1;
    }

    public void setLado1(Double lado1) {
        this.lado1 = lado1;
    }

    public Double getLado2() {
        return lado2;
    }

    public void setLado2(Double lado2) {
        this.lado2 = lado2;
    }

    public Double getLado3() {
        return lado3;
    }

    public void setLado3(Double lado3) {
        this.lado3 = lado3;
    }

    @Override
    public Double calcularArea() {
        return 0.5 * lado1 * lado2;
    }

    @Override
    public Double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }
}
