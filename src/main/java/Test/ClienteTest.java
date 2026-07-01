package Test;

import Digitalers.clase6.integrador.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ClienteTest {

    @Test
    public void calcularEdadDeberiaSerOk(){ //calcularEdadShouldByOk
        LocalDate now = LocalDate.now();
        LocalDate birth = LocalDate.now()
                .minusYears(25)
                .minusMonths(3)
                .minusDays(10);
        System.out.println(birth);
        Cliente client = new Cliente();
        client.setBirth(birth);

        Assertions.assertEquals(25, client.calcularEdad());

    }
}
