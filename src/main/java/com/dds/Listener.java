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

                if (child.getText() == suma.getSimbolo()) {
                    indicador.setOperador(suma);
                }

                else if (child.getText() == resta.getSimbolo()) {
                    indicador.setOperador(resta);
                }

                else {
                    /* Es un termino */
                    Termino termino = iterateTermino(child);

                    if (indicador.getTermino1() == null) {
                        indicador.setTermino1(termino);
                    }
                    else {
                        indicador.setTermino2(termino);
                    }
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

                if (child.getText() == mult.getSimbolo()) {
                    termino.setOperador(mult);
                }

                else if (child.getText() == div.getSimbolo()) {
                    termino.setOperador(div);
                }

                else {
                    /* Es un factor */
                    Factor factor = iterateFactor(child);

                    if (termino.getFactor1() == null) {
                        termino.setFactor1(factor);
                    }
                    else {
                        if (termino.getOperador() instanceof OperadorDIV
                            && factor instanceof Numero
                            && factor.getResultado() == 0) {
                            throw new IndicadorException("El indicador ingresado tiene una division por cero");
                        }

                        termino.setFactor2(factor);
                    }
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
