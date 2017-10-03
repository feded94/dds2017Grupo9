package com.dds.model.metodologia.operadores.binarios;

public class MayorOIgual extends Comparador {
    @Override
    protected boolean compare(Double a, Double b) {
        return a >= b;
    }

    @Override
    public String nombre() {
        return ">=";
    }
}
