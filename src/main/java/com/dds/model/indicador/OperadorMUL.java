package com.dds.model.indicador;

public class OperadorMUL extends Operador {

    public String getSimbolo() {
        return "*";
    }

    public double operar(Indicador izquierda, Indicador derecha) throws IndicadorException {
        return izquierda.getResultado(nombreEmpresa, periodo)
                * derecha.getResultado(nombreEmpresa, periodo);
    }

}