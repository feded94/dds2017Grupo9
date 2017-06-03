package antlr;


import com.dds.indicador.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
    @SpringBootTest

/*
    public class SUMA { //sumo 1+1 y despues le vuelvo a sumar 1 para que de 3

        @Test
        public void testOperadores() {

            OperadorTermino sumar = new OperadorSUM();

            Termino numeroA = new Numero(1);   //con la clase Factor funciona, con la clase Termino no, estaria mal desarrollada la clase Termino

            Termino numeroB = new Numero(1);


            Assert.assertEquals(2, sumar.operar(numeroA, numeroB), 0.01);

            Factor primeraSuma = new Indicador(numeroA, numeroB, sumar); //Indicador deberia tener tres parametros que no estan desarrollados en la Clase Indicador

            Factor segundaSuma = new Indicador(primeraSuma, new Numero(1), sumar);

            Assert.assertEquals(3, segundaSuma.getResultado(), 0.01);
        }


    public class MULTPLICACION { //multiplico 2x2 y despues lo vuelvo a multiplicar por 2 para que de 4

        @Test
        public void testOperadores() {

            OperadorFactor multiplicar = new OperadorMUL();

            Factor numeroA = new Numero(2);

            Factor numeroB = new Numero(2);


            Assert.assertEquals(4, multiplicar.operar(numeroA, numeroB), 0.01);

            Factor expresionAuxiliar = new Indicador(numeroA, numeroB, multiplicar); //Indicador deberia tener tres parametros que no estan desarrollados en la Clase Indicador

            Factor expresionFinal = new Indicador(expresionAuxiliar, new Numero(2), multiplicar);

            Assert.assertEquals(8, expresionFinal.getResultado(), 0.01);
        }


