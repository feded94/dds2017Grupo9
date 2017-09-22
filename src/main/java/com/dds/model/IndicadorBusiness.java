package com.dds.model;

import com.dds.Listener;
import com.dds.antlr.IndicadorLexer;
import com.dds.antlr.IndicadorParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class IndicadorBusiness {
    private Double _valor;
    private String _nombre;
    private String _expresion;

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Double get_valor() {
        return _valor;
    }

    public void set_valor(Double _valor) {
        this._valor = _valor;
    }

    public String get_expresion() {
        return _expresion;
    }

    public void set_expresion(String _expresion) {
        this._expresion = _expresion;
    }

    public void parse() {
        IndicadorLexer lexer = new IndicadorLexer(CharStreams.fromString(this._expresion));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IndicadorParser parser = new IndicadorParser(tokens);
        IndicadorParser.IndicadorContext indicadorContext = parser.indicador();
        ParseTreeWalker walker = new ParseTreeWalker();
        Listener listener = new Listener();

        walker.walk(listener, indicadorContext);

        this._valor = listener.getIndicador().getResultado();
    }
}