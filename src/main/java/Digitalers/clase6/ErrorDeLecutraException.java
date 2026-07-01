package Digitalers.clase6;

import java.io.IOException;

public class ErrorDeLecutraException extends IOException {  //Para que una clase sea una excepcion debe heredar de cualquier excpetion

    public ErrorDeLecutraException(String msg) {
        super(msg);
    }
}

