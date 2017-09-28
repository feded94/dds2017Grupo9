package com.dds.model.metodologia.operadores.binarios;

public class Distinto extends Comparador {
    private final double DELTA = 1e-15;

    @Override
    protected boolean compare(Double a, Double b) {
        return !(b - DELTA < a && a < b + DELTA);
    }
}
