import static org.junit.Assert.*;

import org.junit.Test;

import com.dds.indicador.*;

public class OperadorSUMTest {

	@Test
	public void test() throws IndicadorException {
		
	
		Factor numeroA = new Numero(2);
		Factor numeroB = new Numero(3);
		Factor numeroC = new Numero(4);
		OperadorTermino suma = new OperadorSUM();
		OperadorTermino suma1 = new OperadorSUM();
		
		Termino termino1 = new Termino();
		termino1.addFactor(numeroA);

		Termino termino2 = new Termino();
		termino2.addFactor(numeroB);
		
		// testeo 2+3  = 5 
		assertEquals(5, suma.operar(termino1.getResultado(), termino2), 0.01);
		
		
		
		Termino termino3 = new Termino();
		termino3.addFactor(numeroC);
		
		// testeo 2+3+4 = 9
		Indicador indicador = new Indicador();
		indicador.addTermino(termino1);
		indicador.addTermino(termino2);
		indicador.addTermino(termino3);
		indicador.addOperador(suma);
		indicador.addOperador(suma1);
		assertEquals(9, indicador.getResultado(), 0.01);
		
		
	}

}	
