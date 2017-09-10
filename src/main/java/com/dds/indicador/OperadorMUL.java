package com.dds.indicador;

public class OperadorMUL implements Operador {

    public String getSimbolo() {
        return "*";
    }

    public double operar(Indicador izquierda, Indicador derecha) {
        return izquierda.getResultado() * derecha.getResultado();
    }

}