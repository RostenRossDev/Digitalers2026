package Digitalers.clase21.test1;

public class Avion extends Vehiculo{
    public Turbina turbina;


    public Avion (){
        patente = "asd3sdr4";
    }

    public Turbina getTurbina() {
        return turbina;
    }

    public void setTurbina(Turbina turbina) {
        this.turbina = turbina;
    }


    private class Turbina {

    }
}
