package com.dds.model.indicador;

public class OperadorSUM extends Operador {

    public String getSimbolo() {
        return "+";
    }

    public double operar(Indicador termino1, Indicador termino2) throws IndicadorException {
        return termino1.getResultado(nombreEmpresa, periodo)
                + termino2.getResultado(nombreEmpresa, periodo);
    }
}