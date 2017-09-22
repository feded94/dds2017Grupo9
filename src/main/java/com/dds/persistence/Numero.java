package com.dds.persistence;

import com.dds.persistence.Indicador;

public class Numero extends Indicador {
    private double valor;

    public Numero(double valor) {
        this.valor = valor;
    }

    @Override
    public double getResultado() {
        return valor;
    }

    @Override
    public String toString() {
        return Double.toString(valor);
    }
}
