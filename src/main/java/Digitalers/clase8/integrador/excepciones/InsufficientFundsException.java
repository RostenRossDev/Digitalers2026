package Digitalers.clase8.integrador.excepciones;

public class InsufficientFundsException extends RuntimeException{

    public  InsufficientFundsException(String message){
        super(message);
    }
}
