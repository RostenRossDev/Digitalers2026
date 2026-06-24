package Digitalers.clase6;

public class SuperHeroe {
    //atributos
    private String nombre;
    private Double poder;
    private Double defensa;
    private Double salud;

    //metodo constructor
    public SuperHeroe(){

    }

    // metodo cualquiera
    public double atacar(SuperHeroe oponente){
        return oponente.salud - poder;
    }
}
