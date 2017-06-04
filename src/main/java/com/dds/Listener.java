package com.dds;

import com.dds.antlr.*;
import com.dds.indicador.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;

import com.dds.antlr.IndicadorBaseListener;

public class Listener extends IndicadorBaseListener {
    private Indicador indicadorActual;

    private OperadorTermino suma;
    private OperadorTermino resta;

    private OperadorFactor mult;
    private OperadorFactor div;

    public Listener() {
        super();

        this.suma = new OperadorSUM();
        this.resta = new OperadorRES();
        this.mult = new OperadorMUL();
        this.div = new OperadorDIV();
    }

    @Override
    public void enterIndicador(IndicadorParser.IndicadorContext ctx) {
        try {
            this.indicadorActual = iterateIndicador(ctx);
        }
        catch (IndicadorException ie) {
            System.err.println(ie.getMessage());
            this.indicadorActual = null;
        }
    }

    public Indicador getIndicador() {
        return indicadorActual;
    }

    private Indicador iterateIndicador(ParseTree ctx) throws IndicadorException {
        Indicador indicador = new Indicador();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);

            if (child instanceof ErrorNode) {
                System.err.printf("Error en nodo: %s\n", child.getText());

                throw new IndicadorException("El indicador ingresado no es válido");
            }

            else {
                System.out.printf("Nodo valido: %s\n", child.getText());

                if (child.getText().equals(suma.getSimbolo())) {
                    indicador.addOperador(suma);
                }

                else if (child.getText().equals(resta.getSimbolo())) {
                    indicador.addOperador(resta);
                }

                else {
                    /* Es un termino */
                    indicador.addTermino(iterateTermino(child));
                }
            }
        }

        return indicador;
    }

    private Termino iterateTermino(ParseTree ctx) throws IndicadorException {
        Termino termino = new Termino();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);

            if (child instanceof ErrorNode) {
                System.err.printf("Error en nodo: %s\n", child.getText());

                throw new IndicadorException("El indicador ingresado tiene un termino invalido");
            }

            else {
                System.out.printf("Nodo valido: %s\n", child.getText());

                if (child.getText().equals(mult.getSimbolo())) {
                    termino.addOperador(mult);
                }

                else if (child.getText().equals(div.getSimbolo())) {
                    termino.addOperador(div);
                }

                else {
                    /* Es un factor */
                    termino.addFactor(iterateFactor(child));
                }
            }
        }

        return termino;
    }

    private Factor iterateFactor(ParseTree ctx) throws IndicadorException {
        char firstChar = ctx.getText().charAt(0);

        if (Character.isDigit(firstChar)) {
            return new Numero(Double.parseDouble(ctx.getText()));
        }

        if (firstChar == '(') {
            System.out.println("Indicador: " + ctx.getChild(1).getText());
            return iterateIndicador(ctx.getChild(1));
        }

        return new ID(ctx.getText());
    }
}
