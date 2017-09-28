package com.dds.model.metodologia.operadores.binarios;

public class MenorOIgual extends Comparador {
    @Override
    protected boolean compare(Double a, Double b) {
        return a <= b;
    }
}
