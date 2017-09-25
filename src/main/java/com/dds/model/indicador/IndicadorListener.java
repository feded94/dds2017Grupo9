package com.dds.model.indicador;

import com.dds.antlr.IndicadorParser;
import com.dds.model.indicador.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;

import com.dds.antlr.IndicadorBaseListener;

public class IndicadorListener extends IndicadorBaseListener {
    private Indicador indicadorActual;

    private Operador suma;
    private Operador resta;

    private Operador mult;
    private Operador div;

    public IndicadorListener() {
        super();

        this.suma = new OperadorSUM();
        this.resta = new OperadorRES();
        this.mult = new OperadorMUL();
        this.div = new OperadorDIV();
    }

    @Override
    public void enterIndicador(IndicadorParser.IndicadorContext ctx) {
        if (indicadorActual == null) {
            try {
                this.indicadorActual = iterateIndicador(ctx);
            }
            catch (IndicadorException ie) {
                System.err.println(ie.getMessage());
                this.indicadorActual = null;
            }
        }
    }

    public Indicador getIndicador() {
        return indicadorActual;
    }

    private Indicador iterateIndicador(ParseTree ctx) throws IndicadorException {
        Indicador indicador = null;
        Operador opActual = null;

        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);

            if (child instanceof ErrorNode) {
                System.err.printf("Error en nodo: %s\n", child.getText());

                throw new IndicadorException("El indicador ingresado no es válido");
            }

            else {
                System.out.printf("Nodo valido: %s\n", child.getText());

                if (child.getText().equals(suma.getSimbolo())) {
                    opActual = suma;
                }

                else if (child.getText().equals(resta.getSimbolo())) {
                    opActual = resta;
                }

                else {
                    /* Es un termino */
                    if (indicador == null)
                        indicador = iterateTermino(child);
                    else {
                        indicador = indicador.operarCon(opActual, iterateTermino(child));
                    }
                }
            }
        }

        return indicador;
    }

    private Indicador iterateTermino(ParseTree ctx) throws IndicadorException {
        Indicador termino = null;
        Operador opActual = null;

        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);

            if (child instanceof ErrorNode) {
                System.err.printf("Error en nodo: %s\n", child.getText());

                throw new IndicadorException("El indicador ingresado tiene un termino invalido");
            }

            else {
                System.out.printf("Nodo valido: %s\n", child.getText());

                if (child.getText().equals(mult.getSimbolo())) {
                    opActual = mult;
                }

                else if (child.getText().equals(div.getSimbolo())) {
                    opActual = div;
                }

                else {
                    /* Es un factor */
                    if (termino == null)
                        termino = iterateFactor(child);
                    else {
                        termino = termino.operarCon(opActual, iterateTermino(child));
                    }
                }
            }
        }

        return termino;
    }

    private Indicador iterateFactor(ParseTree ctx) throws IndicadorException {
        char firstChar = ctx.getText().charAt(0);

        if (Character.isDigit(firstChar)) {
            return Indicador.getIndicador(Double.parseDouble(ctx.getText()));
        }

        if (firstChar == '(') {
            System.out.println("Indicador: " + ctx.getChild(1).getText());
            return iterateIndicador(ctx.getChild(1));
        }

        return Indicador.getIndicador(ctx.getText());
    }
}
