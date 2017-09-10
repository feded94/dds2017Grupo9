package com.dds.indicador.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.dds.indicador.*;
import static org.junit.Assert.*;

import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperadorRESTest {

	@Test
	public void test() throws IndicadorException {
		Numero numeroA = (Numero) Indicador.getIndicador(10);
		Numero numeroB = (Numero) Indicador.getIndicador(4);
		Numero numeroC = (Numero) Indicador.getIndicador(7);
		Operador resta = new OperadorRES();

		Indicador termino = numeroA.operarCon(resta, numeroB).operarCon(resta, numeroC);

		//testeo 10 - 4 - 6 = 0
		assertEquals(-1, termino.getResultado(), 0.01);
	}

}	
