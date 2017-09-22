package com.dds.indicador.test;

import com.dds.model.Operador;
import com.dds.model.OperadorMUL;
import com.dds.persistence.Indicador;
import com.dds.persistence.Numero;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest

public class OperadorMULTest {

    @Test
    public void multiplicar() {
        Numero numeroA = (Numero) Indicador.getIndicador(2);
        Numero numeroB = (Numero) Indicador.getIndicador(3);
        Operador multiplicar = new OperadorMUL();

        Indicador factor = Indicador.getIndicador(numeroA, multiplicar, numeroB);

        assertEquals(6, factor.getResultado(), 0.01);
    }
}