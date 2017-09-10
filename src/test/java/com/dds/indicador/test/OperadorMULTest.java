package com.dds.indicador.test;

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
        Numero numeroA = (Numero) Indicador.getIndicador(2);
        Numero numeroB = (Numero) Indicador.getIndicador(3);
        Operador multiplicar = new OperadorMUL();

        Indicador factor = Indicador.getIndicador(numeroA, multiplicar, numeroB);

        assertEquals(6, factor.getResultado(), 0.01);
    }
}