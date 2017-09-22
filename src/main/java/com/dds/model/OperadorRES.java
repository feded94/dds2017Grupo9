package com.dds.model;

import com.dds.persistence.Indicador;

public class OperadorRES implements Operador {

    public String getSimbolo() {
        return "-";
    }

    public double operar(Indicador termino1, Indicador termino2) {
        return termino1.getResultado() - termino2.getResultado();
    }
}