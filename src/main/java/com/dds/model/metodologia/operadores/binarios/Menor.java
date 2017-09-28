package com.dds.model.metodologia.operadores.binarios;

public class Menor extends Comparador {
    @Override
    protected boolean compare(Double a, Double b) {
        return a < b;
    }
}
