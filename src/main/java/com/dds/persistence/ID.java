package com.dds.persistence;

public class ID extends Indicador {
    private String idIndicador;

    protected ID(String idIndicador) {
        this.idIndicador = idIndicador;
    }

    @Override
    public double getResultado() {
        /* TODO: Obtiene el valor del Indicador con idIndicador */
        return 0;
    }

    @Override
    public String toString() {
        return idIndicador;
    }
}
