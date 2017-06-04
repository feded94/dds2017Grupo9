package com.dds.indicador;

public class OperadorRES implements OperadorTermino {

    public String getSimbolo() {
        return "-";
    }

    public double operar(double termino1, Termino termino2) {
        return termino1 - termino2.getResultado();
    }
}