package com.dds.indicador.test;

import com.dds.indicador.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperadorSUMTest {

	@Test
	public void testMultiplicar2x3x4() {
		Operador multiplicar = new OperadorMUL();
		Numero izquierda = (Numero) Indicador.getIndicador(2.0);
		Numero derecha = (Numero) Indicador.getIndicador(3.0);

		Indicador resultado = izquierda.operarCon(multiplicar, derecha);
		Assert.assertEquals(6.0, resultado.getResultado(), 0.01);

		Numero tercerFactor = (Numero) Indicador.getIndicador(4.0);
		Indicador resultadoFinal = resultado.operarCon(multiplicar, tercerFactor);

		assertEquals(24.0, resultadoFinal.getResultado(), 0.01);
	}
}