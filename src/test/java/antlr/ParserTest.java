package antlr;

import com.dds.Listener;
import com.dds.antlr.IndicadorLexer;
import com.dds.antlr.IndicadorParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ParserTest {
    @Test
    public void testParsearDesdeUnString() {
        String testStr = "1 * 2 * 6 / 2";

        IndicadorLexer lexer = new IndicadorLexer(CharStreams.fromString(testStr));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IndicadorParser parser = new IndicadorParser(tokens);
        IndicadorParser.IndicadorContext indicadorContext = parser.indicador();
        ParseTreeWalker walker = new ParseTreeWalker();
        Listener listener = new Listener();

        walker.walk(listener, indicadorContext);

        System.out.println("Indicador parseado : " + listener.getIndicador());
        System.out.println("Valor indicador : " + listener.getIndicador().getResultado());

        Assert.assertEquals(1.0 * 2.0 * 6.0 / 2.0, listener.getIndicador().getResultado(), 0.01);
    }

    @Test
    public void testParsearDesdeUnArchivo() throws IOException {
        String filepath = getInputFilePath("/input.txt");

        System.out.println("Parseando archivo : " + filepath);

        IndicadorLexer lexer = new IndicadorLexer(CharStreams.fromFileName(filepath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IndicadorParser parser = new IndicadorParser(tokens);
        IndicadorParser.IndicadorContext indicadorContext = parser.indicador();
        ParseTreeWalker walker = new ParseTreeWalker();
        Listener listener = new Listener();

        walker.walk(listener, indicadorContext);

        System.out.println("Indicador parseado : " + listener.getIndicador());
        System.out.println("Valor indicador : " + listener.getIndicador().getResultado());

        Assert.assertEquals(1.0 * 2.0 * 6.0 / 2.0, listener.getIndicador().getResultado(), 0.01);
    }

    private String getInputFilePath(String inputPath) throws UnsupportedEncodingException {
        String filePath = this.getClass().getResource(inputPath).getPath();
        filePath = System.getProperty( "os.name" ).contains( "indow" ) ? filePath.substring(1) : filePath;
        filePath = URLDecoder.decode(filePath, "UTF-8");
        return filePath;
    }
}
