package com.dds.indicador;

public class OperadorMUL implements OperadorFactor {

    public String getSimbolo() {
        return "*";
    }

    public double operar(double factor1, Factor factor2) {
        return factor1 * factor2.getResultado();
    }
}