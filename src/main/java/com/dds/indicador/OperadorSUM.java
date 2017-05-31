package com.dds.indicador;

public class OperadorSUM implements OperadorTermino {

    public String getSimbolo() {
        return "+";
    }

    public double operar(Termino termino1, Termino termino2) {
        return termino1.getResultado() + termino2.getResultado();
    }
}