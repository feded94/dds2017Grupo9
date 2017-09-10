package com.dds.indicador;

public class OperadorSUM implements Operador {

    public String getSimbolo() {
        return "+";
    }

    public double operar(Indicador termino1, Indicador termino2) {
        return termino1.getResultado() + termino2.getResultado();
    }
}