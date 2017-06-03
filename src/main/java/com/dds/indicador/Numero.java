package com.dds.indicador;

public class Numero implements Factor{
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
