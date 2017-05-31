package com.dds.indicador;

public class Termino {

    private Factor factor1;
    private OperadorFactor operador;
    private Factor factor2;

    public double getResultado() {
        return operador.operar(factor1, factor2);
    }

    public void setFactor1(Factor factor1) {
        this.factor1 = factor1;
    }

    public void setFactor2(Factor factor2) {
        this.factor2 = factor2;
    }

    public void setOperador(OperadorFactor operador) {
        this.operador = operador;
    }
}