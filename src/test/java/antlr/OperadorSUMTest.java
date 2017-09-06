package antlr;

import com.dds.indicador.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperadorSUMTest {

	@Test
	public void testMultiplicar2x3x4() {
		OperadorFactor multiplicar = new OperadorMUL();
		Factor izquierda = new Numero(2.0);
		Factor derecha = new Numero(3.0);
		Factor resultado = multiplicar.operar(izquierda, derecha);
		Assert.assertEquals(6.0, resultado.getResultado(), 0.01);

		Factor tercerFactor = new Numero(4.0);
		Factor resultadoFinal = multiplicar.operar(resultado, tercerFactor);

		Assert.assertEquals(24.0, resultadoFinal.getResultado(), 0.01);
	}

}
