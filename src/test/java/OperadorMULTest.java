
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.dds.indicador.*;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;


@RunWith(SpringRunner.class)
@SpringBootTest

    public class OperadorMULTest {

    @Test
    public void multiplicar() {

        Factor numeroA = new Numero(2);
        Factor numeroB = new Numero(3);
        OperadorFactor multiplicar = new OperadorMUL();

       /* Termino termino = new Termino();
     
        termino.addFactor(numeroA);

        termino.addOperador(multiplicar);

        termino.addFactor(numeroB); */ 

        assertEquals(5, multiplicar.operar(numeroA.getResultado(), numeroB), 0.01);
        
        
        }
    }