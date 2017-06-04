package com.dds.indicador;

import java.util.ArrayList;

public class Indicador implements Factor {
    private Termino termino;
    private ArrayList<OperadorTermino> operadores;
    private ArrayList<Termino> masTerminos;

    @Override
    public double getResultado() {
        double resultado = termino.getResultado();

        if (operadores == null) {
            return resultado;
        }

        for (int i = 0; i < masTerminos.size(); i++) {
            OperadorTermino op = operadores.get(i);
            Termino t = masTerminos.get(i);

            resultado = op.operar(resultado, t);
        }

        return resultado;
    }

    public void addTermino(Termino termino) {
        if (this.termino == null) {
            this.termino = termino;
        }
        else {
            if (masTerminos == null) {
                masTerminos = new ArrayList<Termino>();
            }
            masTerminos.add(termino);
        }
    }

    public void addOperador(OperadorTermino operador) {
        if (operadores == null) {
            operadores = new ArrayList<OperadorTermino>();
        }
        operadores.add(operador);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(termino.toString());

        if (operadores == null) {
            return sb.toString();
        }

        for (int i = 0; i < masTerminos.size(); i++) {
            OperadorTermino op = operadores.get(i);
            Termino t = masTerminos.get(i);

            sb.append(op.getSimbolo());
            sb.append(t.toString());
        }

        return sb.toString();
    }
}
