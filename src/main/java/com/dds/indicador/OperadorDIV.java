package com.dds.indicador;

public class OperadorDIV implements OperadorFactor {

    public String getSimbolo() {
        return "/";
    }

    public double operar(double factor1, Factor factor2) {
        if (factor2.getResultado() == 0) {
            throw new RuntimeException("No puede dividirse por cero");
        }

        return factor1 / factor2.getResultado();
    }
}