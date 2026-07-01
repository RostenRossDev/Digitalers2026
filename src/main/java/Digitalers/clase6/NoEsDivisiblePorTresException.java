package Digitalers.clase6;

public class NoEsDivisiblePorTresException extends ArithmeticException {  //Para que una clase sea una excepcion debe heredar de cualquier excpetion

    public NoEsDivisiblePorTresException(String msg) {
        super(msg);
    }
}

