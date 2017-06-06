import static org.junit.Assert.*;

import org.junit.Test;

import com.dds.indicador.*;

public class OperadorSUMTest {

	@Test
	public void test() throws IndicadorException {
		
	
		Factor numeroA = new Numero(2);
		Factor numeroB = new Numero(3);
		OperadorTermino suma = new OperadorSUM();
		
		Termino termino1 = new Termino();
		termino1.addFactor(numeroA);

		Termino termino2 = new Termino();
		termino2.addFactor(numeroB);
		
		/*Indicador indicador = new Indicador();
		indicador.addTermino(termino1);
		indicador.addTermino(termino2);
		indicador.addOperador(suma);*/
		assertEquals(5, suma.operar(termino1.getResultado(), termino2), 0.01);
		
		
	}

}	
