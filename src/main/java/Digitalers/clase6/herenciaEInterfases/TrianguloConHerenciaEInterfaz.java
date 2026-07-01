package Digitalers.clase6.herenciaEInterfases;


public class TrianguloConHerenciaEInterfaz extends FiguraGeometrica implements IFiguraGeometrica {

    public TrianguloConHerenciaEInterfaz(Double lado1, Double lado2, Double lado3){
        this.lado1 = lado1;
        this.lado2 = lado2;
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
