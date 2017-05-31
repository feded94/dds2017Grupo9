package com.dds.indicador;

public class OperadorDIV implements OperadorFactor {

    public String getSimbolo() {
        return "/";
    }

    public double operar(Factor factor1, Factor factor2) {
        if (factor1 == null || factor2 == null) {
            throw new RuntimeException("No puede dividirse por cero");
        }

        return factor1.getResultado() / factor2.getResultado();
    }
}