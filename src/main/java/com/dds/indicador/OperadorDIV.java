package com.dds.indicador;

public class OperadorDIV implements OperadorFactor {

    public String getSimbolo() {
        return "/";
    }

    public Factor operar(Factor factor1, Factor factor2) {
        if (factor2.getResultado() == 0) {
            throw new RuntimeException("No puede dividirse por cero");
        }
        return new Numero(factor1.getResultado() / factor2.getResultado());
    }
}