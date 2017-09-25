package com.dds.model.indicador;

public class Numero extends Indicador {
    private double valor;

    public Numero(double valor) {
        this.valor = valor;
    }

    @Override
    public double getResultado(String nombreEmpresa, Integer periodo) {
        return valor;
    }

    @Override
    public String toString() {
        return Double.toString(valor);
    }
}
