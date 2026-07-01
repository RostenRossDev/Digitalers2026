package Digitalers.clase6.herencia;

public class Cuadrado extends FiguraGeometrica{

    public Cuadrado(Double lado1){
        this.lado1 = lado1;
    }

    @Override
    public Double calcularArea() {
        return lado1*lado1;
    }

    @Override
    public Double calcularPerimetro() {
        return lado1*4;
    }

//    public void pedirAyuda(String msg){
//        System.out.println(msg);
//    }
//
//    public void pedirAyuda(String msg, String nombre){
//        System.out.println("Ayudaame " + nombre);
//    }
//
//    public void pedirAyuda(){
//        System.out.println("Aiiuuda");
//    }
}
