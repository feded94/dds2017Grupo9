package com.dds.model.indicador;

public class OperadorDIV extends Operador {
    @Override
    public String getSimbolo() {
        return "/";
    }

    @Override
    public double operar(Indicador factor1, Indicador factor2) throws IndicadorException {
        double f2 = factor2.getResultado(nombreEmpresa, periodo);
        if (f2 == 0) {
            throw new RuntimeException("No puede dividirse por cero");
        }
        return factor1.getResultado(nombreEmpresa, periodo) / f2;
    }
}