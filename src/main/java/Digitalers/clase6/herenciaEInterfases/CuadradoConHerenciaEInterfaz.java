package Digitalers.clase6.herenciaEInterfases;

public class CuadradoConHerenciaEInterfaz extends FiguraGeometrica implements IFiguraGeometrica {

    //constructores
    public CuadradoConHerenciaEInterfaz(Double lado1){
        this.lado1 = lado1;
    }

    //metodos genericos
    @Override
    public Double calcularArea() {
        return lado1*lado1;
    }

    @Override
    public Double calcularPerimetro() {
        return lado1*4;
    }
}
