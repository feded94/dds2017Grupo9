package com.dds.model.indicador.test;

import com.dds.model.indicador.Indicador;
import com.dds.model.indicador.IndicadorException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ParserTest {
    @Test
    public void testParsearDesdeUnString() throws IndicadorException{
        String testStr = "1 * 2 * 6 / 2";

        Indicador indicador = Indicador.parseFromString(testStr);

        System.out.println("Indicador parseado : " + indicador);
        System.out.println("Valor indicador : " + indicador.getResultado("", 0));

        Assert.assertEquals(1.0 * 2.0 * 6.0 / 2.0, indicador.getResultado("", 0), 0.01);
    }

    @Test
    public void testParsearDesdeUnArchivo() throws IOException {
/*        String filepath = getInputFilePath("/input.txt");

        System.out.println("Parseando archivo : " + filepath);

        IndicadorLexer lexer = new IndicadorLexer(CharStreams.fromFileName(filepath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IndicadorParser parser = new IndicadorParser(tokens);
        IndicadorParser.IndicadorContext indicadorContext = parser.indicador();
        ParseTreeWalker walker = new ParseTreeWalker();
        IndicadorListener listener = new IndicadorListener();

        walker.walk(listener, indicadorContext);

        System.out.println("Indicador parseado : " + listener.getIndicador());*/
/*        System.out.println("Valor indicador : " + listener.getIndicador().getResultado());

        Assert.assertEquals(1.0 * 2.0 * 6.0 / 2.0, listener.getIndicador().getResultado(), 0.01);*/
    }

    private String getInputFilePath(String inputPath) throws UnsupportedEncodingException {
        String filePath = this.getClass().getResource(inputPath).getPath();
        filePath = System.getProperty( "os.name" ).contains( "indow" ) ? filePath.substring(1) : filePath;
        filePath = URLDecoder.decode(filePath, "UTF-8");
        return filePath;
    }
}
