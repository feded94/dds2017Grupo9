package com.dds.indicador;

public class Numero extends Indicador {
    private double valor;

    protected Numero(double valor) {
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
