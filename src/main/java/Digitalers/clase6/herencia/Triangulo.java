package Digitalers.clase6.herencia;

public class Triangulo extends FiguraGeometrica{

    public Triangulo(Double lado1, Double lado2, Double lado3){
//        this.setLado1(lado1);   //lado 1 es base
//        this.setLado2(lado2);  // lado 2 es altura
//        this.setLado3(lado3);
//        super(lado1, lado2, lado3);
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
