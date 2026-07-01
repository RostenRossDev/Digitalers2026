package Digitalers.clase6;

public class SuperPersona {
    //atributos
    String nombre;
    protected Integer poder;
    private Integer defensa;
    private Double salud;

    //metodo constructor
    public SuperPersona(){
        System.out.println("Invocaron el metodo constructor de la clase superheroe");
    }

    public SuperPersona(String nombre){
        System.out.println("Invocaron el metodo constructor de la clase superheroe");
        this.nombre = nombre;
    }

    public SuperPersona(String nombre, Integer power){
        System.out.println("Invocaron el metodo constructor de la clase superheroe");
        this.nombre = nombre;
        this.poder = power;
    }

    public SuperPersona(String nombre, Integer power, Integer defense){
        System.out.println("Invocaron el metodo constructor de la clase superheroe");
        this.nombre = nombre;
        this.poder = power;
        this.defensa = defense;
    }

    public SuperPersona(String nombre, Integer power, Integer defense, Double health){
        System.out.println("Invocaron el metodo constructor de la clase superheroe");
        this.nombre = nombre;
        this.poder = power;
        this.defensa = defense;
        this.salud = health;
    }


    //Metodos Setters
    public void setNombre(String name) throws Exception {
        if (name != null) {
            this.nombre = name;
        } else {
            throw new Exception("El nombre no puede ser nulo!!!! >:^");
        }
    }

    public String getNombre(){
        return this.nombre;
    }

    // metodo cualquiera
    public double atacar(SuperPersona oponente){
        return oponente.salud - poder;
    }
}
