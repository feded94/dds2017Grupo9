package com.dds.model.indicador;

import com.dds.antlr.IndicadorLexer;
import com.dds.antlr.IndicadorParser;
import com.dds.model.Dato;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public abstract class Indicador implements Dato {
    public static Indicador getIndicador(String nombre) {
        return new ID(nombre);
    }

    public static Indicador getIndicador(double valor) {
        return new Numero(valor);
    }

    public static Indicador getIndicador(Indicador izq, Operador op, Indicador der) {
        return new IndicadorCompuesto(izq, op, der);
    }

    public Indicador operarCon(Operador op, String nombre) {
        return new IndicadorCompuesto(this, op, getIndicador(nombre));
    }

    public Indicador operarCon(Operador op, double numero) {
        return new IndicadorCompuesto(this, op, getIndicador(numero));
    }

    public Indicador operarCon(Operador op, Indicador indicador) {
        return new IndicadorCompuesto(this, op, indicador);
    }

    public static Indicador parseFromString(String s) {
        IndicadorLexer lexer = new IndicadorLexer(CharStreams.fromString(s));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IndicadorParser parser = new IndicadorParser(tokens);
        IndicadorParser.IndicadorContext indicadorContext = parser.indicador();

        ParseTreeWalker walker = new ParseTreeWalker();
        IndicadorListener listener = new IndicadorListener();

        walker.walk(listener, indicadorContext);

        return listener.getIndicador();
    }

    @Override
    public abstract double getResultado(String nombreEmpresa, Integer periodo) throws IndicadorException;

    @Override
    public abstract String toString();
}
