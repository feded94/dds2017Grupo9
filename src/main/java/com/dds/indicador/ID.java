package com.dds.indicador;

public class ID implements Factor{
    private String idIndicador;

    public ID(String idIndicador) {
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
