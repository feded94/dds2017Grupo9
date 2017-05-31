package com.dds.indicador;

public class OperadorMUL implements OperadorFactor {

    public String getSimbolo() {
        return "*";
    }

    public double operar(Factor factor1, Factor factor2) {
        return factor1.getResultado() * factor2.getResultado();
    }
}