import static org.junit.Assert.*;

import org.junit.Test;

import com.dds.indicador.*;

public class OperadorRESTest {

	@Test
	public void test() throws IndicadorException {
		
	
		Factor numeroA = new Numero(10);
		Factor numeroB = new Numero(4);
		Factor numeroC = new Numero(6);
		OperadorTermino resta = new OperadorRES();
		OperadorTermino resta1 = new OperadorRES();
		
		Termino termino1 = new Termino();
		termino1.addFactor(numeroA);

		Termino termino2 = new Termino();
		termino2.addFactor(numeroB);
		
		Termino termino3 = new Termino();
		termino3.addFactor(numeroC);
		
		//testeo 10 - 4 = 6
		assertEquals(6, resta.operar(termino1.getResultado(), termino2), 0.01);
		
		Indicador indicador = new Indicador();
		indicador.addTermino(termino1);
		indicador.addTermino(termino2);
		indicador.addTermino(termino3);
		indicador.addOperador(resta);
		indicador.addOperador(resta1);
		
		assertEquals(0, indicador.getResultado(), 0.01);
		
		
		
	}

}	
