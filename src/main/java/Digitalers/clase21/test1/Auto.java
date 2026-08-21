package Digitalers.clase21.test1;

public final class Auto extends Vehiculo{

    private Motor motor;
    private String modelo;
    private Color color;   //Azul, Rojo, verde, Amarillo y Purpura
    private Boolean encendido;
    static private String concesionaria; //= "Consesionaria Educacion IT";

    static {
        concesionaria = "Consesionaria Educacion IT";
    }

    public Auto(){
        motor = new Motor();
        color = Color.verde;
        patente = "asdhjashj4543";
    }

    public Motor getMotor() {
        return motor;
    }


    public void setMotor(Motor motor) {
        /*... codigo con logica de validacion*/
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean isEncendido(){
        return encendido;
    }

    public static String getConcesionaria() {
        System.out.println();
        return concesionaria;
    }

    private class Motor {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
