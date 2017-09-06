package com.dds.indicador;

public class OperadorMUL implements OperadorFactor {

    public String getSimbolo() {
        return "*";
    }

    public Factor operar(Factor izquierda, Factor derecha) {
        return new Numero(izquierda.getResultado() * derecha.getResultado());
    }

}