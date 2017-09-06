package com.dds.indicador;

import java.util.ArrayList;

public class Termino {

    private Factor factor;
    private ArrayList<OperadorFactor> operadores;
    private ArrayList<Factor> masFactores;

    public double getResultado() {
        double resultado = factor.getResultado();

        if (operadores == null) {
            return resultado;
        }

        for (int i = 0; i < masFactores.size(); i++) {
//            OperadorFactor op = operadores.get(i);
//            Factor f = masFactores.get(i);
//
//            resultado = op.operar(factor, f);
        }

        return resultado;
    }

    public void addFactor(Factor factor) throws IndicadorException {
        if (this.factor == null) {
            this.factor = factor;
        }
        else {
            if (operadores.get(operadores.size() - 1) instanceof OperadorDIV
                && factor.getResultado() == 0) {
                throw new IndicadorException("El indicador ingresado tiene una division por cero");
            }

            if (masFactores == null) {
                masFactores = new ArrayList<Factor>();
            }

            masFactores.add(factor);
        }
    }

    public void addOperador(OperadorFactor operador) {
        if (operadores == null) {
            operadores = new ArrayList<OperadorFactor>();
        }

        operadores.add(operador);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(factor.toString());

        if (operadores == null) {
            return sb.toString();
        }

        for (int i = 0; i < masFactores.size(); i++) {
            OperadorFactor op = operadores.get(i);
            Factor f = masFactores.get(i);

            sb.append(op.getSimbolo());
            sb.append(f.toString());
        }

        return sb.toString();
    }
}