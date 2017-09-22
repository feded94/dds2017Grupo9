package com.dds.model;

import com.dds.persistence.Indicador;

public class OperadorMUL implements Operador {

    public String getSimbolo() {
        return "*";
    }

    public double operar(Indicador izquierda, Indicador derecha) {
        return izquierda.getResultado() * derecha.getResultado();
    }

}