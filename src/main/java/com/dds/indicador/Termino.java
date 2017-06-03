package com.dds.indicador;

public class Termino {

    private Factor factor1;
    private OperadorFactor operador;
    private Factor factor2;

    public double getResultado() {
        if (factor2 == null) {
            return factor1.getResultado();
        }

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

    public Factor getFactor1() {
        return factor1;
    }

    public Factor getFactor2() {
        return factor2;
    }

    public OperadorFactor getOperador() {
        return operador;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(factor1.toString());

        if (factor2 != null) {
            sb.append(operador.getSimbolo());
            sb.append(factor2.toString());
        }

        return sb.toString();
    }
}