package com.dds;

import com.dds.antlr.*;
import com.dds.indicador.*;
import org.antlr.v4.runtime.ParserRuleContext;
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
        this.indicadorActual = new Indicador();

        iterateIndicador(ctx);
    }

    private void iterateIndicador(IndicadorParser.IndicadorContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);

            if (child instanceof ErrorNode) {
                System.err.printf("Error en nodo: %s\n", child.getText());
            }

            else {
                System.out.printf("Nodo valido: %s\n", child.getText());

                if (child.getText() == suma.getSimbolo()) {
                    this.indicadorActual.setOperador(suma);
                }

                else if (child.getText() == resta.getSimbolo()) {
                    this.indicadorActual.setOperador(resta);
                }

                else {
                    /* Es un termino */
                    Termino termino = iterateTermino(child);

                    /* TODO */
                }
            }
        }
    }

    private Termino iterateTermino(ParseTree tree) {
        Termino termino = new Termino();

        for (int i = 0; i < tree.getChildCount(); i++) {
            ParseTree child = tree.getChild(i);

            if (child instanceof ErrorNode) {
                System.err.printf("Error en nodo: %s\n", child.getText());
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

                    /* TODO */
/*                    iterateFactor();*/
                }
            }
        }
        return termino;
    }
}
